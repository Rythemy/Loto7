import java.util.Scanner;
import java.util.Random;

public class Loto7 {
	public int yourNumber[] = new int[7];
	public int houseNumber[] = new int[7];
	final static int UPPER_BOUND = 9;
	
	Random rand = new Random();
	
	public void welcome () {
		 System.out.println("Hello. Welcome to Loto 7.");
		 System.out.println("Please choose seven 1-digit numbers. You can also have the program generating the numbers for you.");
		 System.out.println("If all of your numbers match the winning numbers, you win the prize of 100,000 points!");
		 System.out.println("");
	}
	
	public void askForDecision (Scanner scan) {
		System.out.println("Do you want to choose 7 numbers by yourself or have the program generate them?");
		System.out.println("1. I will choose by myself");
		System.out.println("2. Please choose them for me");
		int answer = scan.nextInt();
		 switch (answer) {
			 case 1:
				 System.out.println("Excellent. Please enter your own 7 numbers: ");
				 this.inputNumbers(scan);
				 this.outputNumbers();
				 break;
			 case 2:
				 System.out.println("Good idea. Here are your generated numbers: ");
				 this.generateNumbers();
				 this.outputNumbers();
				 break;
		 }
	}
	
	public void inputNumbers(Scanner scan) {
		for (int i = 0; i < yourNumber.length; i++) {
			yourNumber[i] = scan.nextInt();
		}
	}
	
	
	public void generateNumbers() {
		for (int i = 0; i < yourNumber.length; i++) {
			yourNumber[i] = rand.nextInt(UPPER_BOUND);
		}
	}
	
	public void outputNumbers() {
		System.out.println("Your numbers are: ");
		System.out.print(yourNumber[0]);
		for (int i = 1; i < yourNumber.length; i++) {
			System.out.print(", " + yourNumber[i]);
		}
		System.out.println("");
	}
	
	public void draw() throws InterruptedException {
		 Thread.sleep(1000);
		 System.out.println("Now's the time for the drawing!");
		 Thread.sleep(1000);
		 System.out.println("3");
		 Thread.sleep(1000);
		 System.out.println("2");
		 Thread.sleep(1000);
		 System.out.println("1");
		for (int i = 0; i < houseNumber.length; i++) {
			houseNumber[i] = rand.nextInt(UPPER_BOUND);
		}
		
		System.out.printf("...and the winner numbers are: \n");
		Thread.sleep(1000);
		System.out.print(houseNumber[0]);
		for (int i = 1; i < houseNumber.length; i++) {
			System.out.print(", "+ houseNumber[i]);
		}
		System.out.println("");	
		Thread.sleep(2000);
	}
	
	public void match() {
		if (yourNumber.equals(houseNumber)) {
			System.out.println("Congratulations! You won!");
		}
		else {
			System.out.println("Sorry! Better luck next time!");
		}
	
	}
}
