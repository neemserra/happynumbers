package neem.happynumbers;

import java.io.*;

public class NumbersIO {
/**
 * Asks user to input an integer, outputs whether or not the integer is a happy number	
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException{
		System.out.println("Please input an integer: ");
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
	    String inputLine = userInput.readLine();
		
	    try {
	    	int integerInput = Integer.parseInt(inputLine);
			HappyProcessor happyNumber = new HappyProcessor(integerInput);
			happyNumber.isNumberHappy(integerInput);
			
			System.out.print(happyNumber.getHappy());
	    }
	      
	    catch (NumberFormatException e) {
	    	System.err.println("Input is not an integer");
	    }
	}

}

