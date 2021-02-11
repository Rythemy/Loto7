import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Loto7 {
	ArrayList yourNumber = new ArrayList();
	ArrayList houseNumber = new ArrayList();
	final static int UPPER_BOUND = 36;
	
	Random rand = new Random();
	
	public void welcome () {
		 System.out.println("Hello. Welcome to Loto 7.");
		 System.out.println("Please choose seven 1-digit numbers. You can also have the program generating the numbers for you.");
		 System.out.println("You will win prizes base on how many numbers you get it right. The highest prize will be $6,000,000!");
		 System.out.println("");
	}
	
	
	public void inputChoice (Scanner scan) {
		System.out.println("Do you want to choose 7 numbers by yourself or have the program generate them?");
		System.out.println("1. I will choose them by myself");
		System.out.println("2. Please choose them for me");		
		boolean repeat = true;
		do {
			try {
				int choice = scan.nextInt();
				if (choice < 1 || choice > 2) {
	                System.out.println("Invalid choice. Please choose an option (1 or 2 only). Please try again.");
	                repeat = true;
	            }
				if (choice == 1) {
					this.inputNumbers(scan);
					this.generateHouseNumber();
					repeat = false;
				}
				if (choice == 2) {
					this.generateYourNumber();
					this.generateHouseNumber();
					repeat = false;
				}
			} catch (Exception e) {
				System.out.println("Invalid input. Please choose a number (1 or 2 only). Please try again.");
				scan.nextLine();
				repeat = true;
			}
		} while (repeat);
		scan.close();
	}
	
	public void inputNumbers(Scanner scan) {
		boolean repeat = true;
		System.out.println("Excellent! Please enter your own 7 numbers, separated by space: ");
		do {
			try {
				for (int i = 0; i < 7; i++) {
					int input = scan.nextInt();
					if (input >0 && input <=37 && !yourNumber.contains(input)) {
						yourNumber.add(input);
					} else if (input <=0 || input >37){
						System.out.println("Please enter a number between 1-37.");
						repeat = true;
						i--;
						scan.nextLine();
					} else if (yourNumber.contains(input)) {
						System.out.println("Number already chose, please choose another number.");
						repeat = true;
						i--;
						scan.nextLine();
					}
				} repeat = false;
			} catch (Exception e) {
				System.out.print("There's an error: " + e + "\n");
				System.out.println("Please try again.");
				repeat = true;
				scan.nextLine();
			}
		} while (repeat);
		yourNumber.sort(null);
	}
	
	public void generateYourNumber() {
		boolean repeat = true;
		System.out.println("Good idea! We will prepare the numbers for you.");	
		do {
			for (int i = 0; i < 7; i++) {
					int random = rand.nextInt(UPPER_BOUND) + 1;
					if (!yourNumber.contains(random)) {
						yourNumber.add(random);
					} else {
						i--;
						repeat = true;
					}
				} repeat = false; 
		} while (repeat);
		yourNumber.sort(null);
	}
	
	public void generateHouseNumber() {
		boolean repeat = true;
		do {
			for (int i = 0; i < 7; i++) {
					int random = rand.nextInt(UPPER_BOUND) + 1;
					if (!houseNumber.contains(random)) {
						houseNumber.add(random);
					} else {
						i--;
						repeat = true;
					}
				} repeat = false; 
		} while (repeat);
		houseNumber.sort(null);
	}
	
	
	public void outputYourNumber() {
		System.out.println("Your numbers are: ");
		System.out.println(yourNumber);
		System.out.println("");
	}
	
	public void outputHouseNumber() {
		System.out.println("...And the winner numbers are: ");
		System.out.println(houseNumber);
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
		Thread.sleep(1000);
	}
	
	public void match() {
		houseNumber.retainAll(yourNumber);
		System.out.print("You have matched total of " + houseNumber.size() + " numbers: ");
		System.out.println(houseNumber);
		if (houseNumber.size() == 6) {
			System.out.println("Congratulations! You won first prize of $6,000,000!");
		}
		else if (houseNumber.size() == 5) {
			System.out.println("Congratulations! You won second prize of $72,800!");
		}
		else if (houseNumber.size() == 4) {
			System.out.println("Congratulations! You won third prize of $7,280!");
		}
		else if (houseNumber.size() == 3) {
			System.out.println("Congratulations! You won fourth prize of $91!");
		}
		else if (houseNumber.size() == 2) {
			System.out.println("Congratulations! You won fifth prize of $14!");
		}
		else {
			System.out.println("Sorry! Better luck next time!");
			System.out.println("Thank you for playing Loto 7.");
		}
	}
}