import java.util.Scanner; 

/*  Determine which Fibonacci numbers are divisible by 5, 
 *  which are divisible by 7, and which are divisible by 11. 
 *  Prove that your conjectures are correct.
 */

public class FibonacciNumbers {
	
	private static void fibonacci(int fibonacci[], int count) {
		if(count < 30) {
			fibonacci[count] = fibonacci[count - 1] + fibonacci[count - 2]; 
			count++;
			fibonacci(fibonacci, count); 
		}  
	}
	
	private static void inductiveReasoning(int number) {
		System.out.println();
		int case1, case2; 
		if(number == 5) {
			System.out.println("Inductive reasoning: take cases '35' and '1445'.");
			case1 = 30; 
			case2 = 1445; 
			System.out.println("Hypothesis: any number ending in 0 or 5 is divisible by 5."); 
			case1 %= 5; 
			case2 %= 5; 
			System.out.println("Cases are proved if these numbers equal 0: " +case1+ " " +case2); 
		} else if (number == 7) {
			int firstNum, secondNum; 
			System.out.println("Inductive reasoning: take cases '623' and '3423'.");
			System.out.println("Hypothesis: subtracting the product of 2 x the last digit from the "
					+ "remaining digits equals a number that is divisible by 7."); 
			firstNum = 2 * 3; 
			secondNum = 62 - firstNum; 
			case1 = secondNum % 7; 
			System.out.print("Cases are proved if these numbers equal 0: " +case1);
			firstNum = 2 * 3;
			secondNum = 342 - firstNum; 
			case2 = secondNum % 7;  
			System.out.println(" " +case2);
		} else if (number == 11) {
			System.out.println("Inductive reasoning: take cases '2728' and '198'.");
			case1 = 2728; 
			case2 = 198; 
			System.out.println("Hypothesis: the alternating sum of the digits of a number is divisible by 11."); 
			case1 = (2 - 7 + 2 - 8) % 11; 
			case2 = (1 - 9 + 8) % 11; 
			System.out.println("Cases are proved if these numbers equal 0: " +case1+ " " +case2);
		}
	}
	
	private static void isMultipleOfFive(int fibonacci[], int count) {
		if (count < 30) {
			if(fibonacci[count] %5 == 0) {
				System.out.println("Element number " +count+ " with value " +fibonacci[count]+ " is a multiple of five.");
			}
			count++;
			isMultipleOfFive(fibonacci, count);
		}
	}
	
	private static void isMultipleOfSeven(int fibonacci[], int count) {
		if (count < 30) {
			if(fibonacci[count] %7 == 0) {
				System.out.println("Element number " +count+ " with value " +fibonacci[count]+ " is a multiple of seven.");
			}
			count++;
			isMultipleOfSeven(fibonacci, count);
		}
	}
	
	private static void isMultipleOfEleven(int fibonacci[], int count) {
		if (count < 30) {
			if(fibonacci[count] %11 == 0) {
				System.out.println("Element number " +count+ " with value " +fibonacci[count]+ " is a multiple of eleven.");
			}
			count++;
			isMultipleOfEleven(fibonacci, count);
		}
	}
	
	public static void main(String[] args) {
		String yesOrNo = "Y"; 
		int count = 3; //starts at 3  
		int multipleNum = 0; 
		
		int fibonacci[] = new int[30];
		
		//note that the first 3 elements must be present to calculate fibonacci sequence  
		fibonacci[0] = 0; 
		fibonacci[1] = 1; 
		fibonacci[2] = 1; 
		
		//load numbers into array of 30 elements 
		fibonacci(fibonacci, count); 
		
		count = 0; //reset count
		Scanner sc = new Scanner(System.in); 
		while(yesOrNo.equalsIgnoreCase("Y")) {
			System.out.println("Enter either 5, 7, or 11.");
			multipleNum = sc.nextInt(); 
			if(multipleNum == 5) {
				isMultipleOfFive(fibonacci, count);
				inductiveReasoning(multipleNum); 
				System.out.println(); 
			} else if (multipleNum == 7) {
				isMultipleOfSeven(fibonacci, count);
				inductiveReasoning(multipleNum); 
				System.out.println();
			} else if (multipleNum == 11) {
				isMultipleOfEleven(fibonacci, count);
				inductiveReasoning(multipleNum); 
				System.out.println();
			} else {
				System.out.println("Please choose either 5, 7, or 11."); 
			} 
			System.out.println("Would you like to enter another number? Enter Y or N.");
			yesOrNo = sc.next(); 
		}
		
		System.out.println("\nProgram complete."); 		
		sc.close(); 
	}
}