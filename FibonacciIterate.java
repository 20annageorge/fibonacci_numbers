import java.util.Scanner; 

/*  Given a nonnegative integer n, 
 *  find the nth Fibonacci number using iteration.
 */

public class FibonacciIterate {

	private static void fibonacci(int fibonacci[], int count) {
		if(count < 30) {
			fibonacci[count] = fibonacci[count - 1] + fibonacci[count - 2]; 
			count++;
			fibonacci(fibonacci, count); 
		}  
	}
	
	private static Boolean checkValid(long number) {
		if (number > 0 && number <= 30) {
			return true; 
		} else {
			return false; 
		}
	}
	
	public static void main(String[] args) {

		String yesOrNo = "Y"; 
		int count = 3; 
		int fibonacci[] = new int[30];
		int num = 0; 
		fibonacci[0] = 0; 
		fibonacci[1] = 1; 
		fibonacci[2] = 1; 
		
		//load numbers into array of 30 elements 
		fibonacci(fibonacci, count); 
		
		Scanner sc = new Scanner(System.in);
		while(yesOrNo.equalsIgnoreCase("Y")) {
			System.out.println("Enter a number from 1 to 30."); 
			num = sc.nextInt();
			if(checkValid(num)) {
				System.out.println("Your number is " +fibonacci[num-1]+ " with the index position " +num); 
				System.out.println("Do you want to enter another number? Y or N"); 
				yesOrNo = sc.next(); 
			} else {
				System.out.println("Your number is not valid. Do you want to enter another number? Y or N");
				yesOrNo = sc.next();
			}
		}
		
		System.out.println("Program done.");
		sc.close(); 
	}
}