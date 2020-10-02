package main.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void print(String message) {
		System.out.println(message);
	}

	@Override
	public int readInt(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return sc.nextInt();
				
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Please insert a proper value");
			}
			
		}
	}

	@Override
	public int readInt(String prompt, int min, int max) {
		int userInput;
		while (true) {
			try {
				System.out.print(prompt);
				userInput = sc.nextInt();
				if(userInput >= min &&  userInput <= max) {
					return userInput;
				}
				
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Please insert a proper value");
			}
			
		}
	}

	@Override
	public String readString(String prompt) {
		while (true) {
			
			try {
				System.out.println(prompt);
				return sc.next();
				
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Please insert a proper value");
			}
			
		}
	}

}
