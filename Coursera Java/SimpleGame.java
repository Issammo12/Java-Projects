import java.util.Scanner;

public class SimpleGame {
	public String convertTime(int seconds){
		int hours = seconds / 3600;
        int remainingSeconds = seconds % 3600;
        int minutes = remainingSeconds / 60;
        int secs = remainingSeconds % 60;
        return hours + ":" + minutes + ":" + secs;
		
	}
	public int  digitSum(int input){
		  int sum = 0;

        while (input > 0) {
            sum += input % 10; // Get the last digit
            input /= 10; // Remove the last digit
        }

        return sum;
    }
		
	}
	
	public static void main(String[] args) {
		// Create an instance of the SimpleGame class.
		// TODO: Your code goes here
		SimpleGame sp= new SimpleGame();
		Scanner sc =new Scanner(System.in);
		System.out.println("enter your number : 1 or 2 :");
        int choice = sc.nextInt();
		// Ask the user which game to play.
		// Then ask the user for input and pass the value to the corresponding method.
		switch (choice) {
            case 1:
                System.out.print("Enter the number of seconds: ");
                int seconds = sc.nextInt();
				String result=sp.convertTime(seconds);
                System.out.println("Time: " + result);
                break;
            case 2:
                System.out.print("Enter a non-negative integer: ");
                int number = sc.nextInt();
				int r=sp.digitSum(number);
                System.out.println("Sum of digits: " + r);
                break;
            default:
                System.out.println("Invalid choice! Please enter 1 or 2.");
                break;
        }
		// If the user enters 1, ask for an integer to convert and call the convertTime method.
		// If the user enters 2, ask for an integer and call the digitsSum method.
		
		// TODO: Your code goes here
		
		sc.close();
	}	
