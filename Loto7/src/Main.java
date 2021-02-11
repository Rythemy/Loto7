// Loto 7
// Version 1.2

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) throws InterruptedException {				 
		 
		 Scanner scan = new Scanner(System.in);
		 Loto7 loto7 = new Loto7();
		 
		 loto7.welcome();
		 loto7.inputChoice(scan);
		 loto7.outputYourNumber();
		 loto7.draw();
		 loto7.outputHouseNumber();
		 loto7.match();
	 }
}


