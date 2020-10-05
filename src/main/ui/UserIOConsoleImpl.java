package main.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.exceptions.InputOutOfRangeException;

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
				System.out.println("Please insert an integer value");
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
				}else {
					throw new InputOutOfRangeException(min, max);
				}
				
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Please insert an integer value");
			}catch(InputOutOfRangeException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

	@Override
	public String readString(String prompt) {
		String userInput;
		while (true) {
			
			try {
				sc.nextLine();
				System.out.print(prompt);
				userInput = sc.nextLine();
				return userInput;
				
			} catch (InputMismatchException e) {
//				sc.nextLine();
				System.out.println("Please insert a proper value");
			}
			
		}
	}

}
