import java.util.Calendar;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * A nice little game I learn from my sister via instagram.  Can predict one's age.
 * 
 * Not a very efficient implementation. And really, this game is just a numbers trick.
 * 
 * Took an hour and some change to complete.
 * @author Tim Stelter
 *
 */
public class BirthdayGuess {

	// These numbers need to be incremented +1 each year to give the correct birthday.
    public static final int YES_NUM = Calendar.getInstance().get(Calendar.YEAR) - 249;	
    public static final int NO_NUM  = Calendar.getInstance().get(Calendar.YEAR) - 251;	
    
    // Program Start - main
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		Integer num = 0;
		Integer newNum = 0;
		Integer yearBorn = 0;
		boolean bool = false;
		Integer newNumTwo = 0;
		
		System.out.println("Hi!");
		
		try {
			// Not the best way to use this time delay.
			TimeUnit.SECONDS.sleep(2);
			System.out.println("I'm going to try and guess your age!");
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Figure out a number between 1 and 10
		while(true) {
			System.out.println("Please pick a number between 1 and 10: ");
			num = scan.nextInt();
			if(num >= 1 && num <= 10) {
				break;
			}
		}
		
		// Get the year the player is born
		System.out.println("What year were you born?: ");
		yearBorn = scan.nextInt();
		
		// Start Calculations
		newNum = ((num * 2) + 5 )* 50;
		
		// Determine if the player has had their birthday this year
		System.out.println("Have you already had your birthday this calender year? (Y/N)");
		while(!bool) {
			switch(scan.next()) {
				case "Y":
					newNumTwo = (newNum + YES_NUM) - yearBorn;
					bool = true;
					break;
				case "N":
					newNumTwo = (newNum + NO_NUM) - yearBorn;
					bool = true;
					break;
				default:
					System.out.println("Please use \"Y\" or \"N\".");
					System.out.println("Have you already had your birthday this year? (Y/N)");
			}
		}
		
		System.out.print("Is your age...");
		
		String str = newNumTwo.toString();
		if(num != 10) {
			str = str.substring(1, str.length());
		} else {
			str = str.substring(2, str.length());
		}
		
		// Wait for it..
		try {
			int check = 2;
			int count = 0;
			// Cool little "dot" loading thing
			while(count <= check) {
				System.out.print(".");
				count++;
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Boom, headshot
		System.out.println("\n" + str);
		
	}

}
