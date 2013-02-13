package neem.happynumbers;

import java.util.*;

/**
 * Author: Neem Serra
 * Ruby Quiz #93
 * Rules:
 * Write a program that tells whether a given integer is happy. A happy number is found using the following process: 
 * Take the sum of the squares of its digits, and continue iterating this process until it yields 1, or produces an 
 * infinite loop. 
 * The program asks for user input of an integer, outputs true (happy number) or false (unhappy number).
 */

public class HappyProcessor {

	int processNumber;
	private int finalNumber;
	private boolean happiness = false;
	private List<Integer> intermediateNumbers = new ArrayList<Integer>();
	
	//List of known unhappy numbers, less memory intensive way to find infinite loops
	private final static List<Integer> unhappyKnown = Arrays.asList(0, 4, 16, 20, 37, 42, 58, 89, 145);

	//happinessRank is the number of intermediateNumbers that are also happyNumbers
	private int happinessRank;
	
	/**
	 * Initializes HappyProcessor class
	 * @param inputNumber
	 */
	public HappyProcessor(int inputNumber){
		processNumber = inputNumber;
		intermediateNumbers.add(inputNumber);
	}
	
	/**
	 * Returns the happiness of a number
	 * @return happiness
	 */
	public boolean getHappy() {
		return happiness;
	}
	
	/**
	 * Returns the list of intermediate numbers (numbers that were processed until decision was made)
	 * @return intermediateNumbers
	 */
	public List<Integer> getIntermediateNumbers() {
		return intermediateNumbers;
	}
	
	/**
	 * Returns the final number upon which the decision was based on (happy or not)
	 * @return finalNumber
	 */
	public int getFinalNumber() {
		return finalNumber;
	}
	
	/**
	 * Returns the happinessRank, which is the number of intermediate numbers that are also happy numbers
	 * @return happinessRank
	 */
	public int getHappinessRank() {
		return happinessRank;
	}
	
	/**
	 * Parses user provided number into digits, takes the squares of each digit and adds them together,
	 * repeats process until the final number is 1 (happy number) or there is an infinite loop
		 * 1. parse numbers, put into an array
		 * 2. take all numbers from array, square them
		 * 3. add all of those numbers together
		 * 4. if the final number equals 0, 4, 16, 20, 37, 42, 58, 89, or 145, then output that it's an unhappy number
		 * 5. if the final number is 1, then output that it is a happy number
	 * @param processNumber
	 */
	public void isNumberHappy(int processNumber){
		List<Integer> numberArray = new ArrayList<Integer>();
		numberArray = parse(processNumber);
		square(numberArray);
		int total = add(numberArray);
		iterate(total);
	}
	
	/**
	 * Takes in an integer and parses it into a list of digits (backwards order)
	 * @param numberToParse
	 * @return List of digits called digits
	 */
	public List<Integer> parse(int numberToParse){
		List<Integer> digits = new ArrayList<Integer>();
		
		while (numberToParse > 0) {
		     digits.add(numberToParse % 10);
		     numberToParse /= 10;
		 }
		
		return digits;
	}
	
	/**
	 * Takes in an List and squares each of the values
	 * @param numberArray
	 */
	public void square(List<Integer> numberArray){

		for (int index = 0; index < numberArray.size(); index++)
		{
			int squareValue = numberArray.get(index) * numberArray.get(index);
			numberArray.set(index, squareValue);
		}
	}
	
	/**
	 * Takes in an List and adds each element together
	 * @param squareArray
	 * @return int squaredTotal
	 */
	public int add(List<Integer> squareArray){
		int squaredTotal = 0;
		
		for (int index = 0; index < squareArray.size(); index++)
		{
			squaredTotal += squareArray.get(index);
		}

		return squaredTotal;	
	}
	
	/**
	 * Takes in an integer and determines if it is a happy number, unhappy number, or needs to be further processed)
		 * Number is happy if it is 1
		 * Number is unhappy if it is 0, 4, 16, 20, 37, 42, 58, 89, or 145 or it creates an infinite loop
		 * Infinite loops are detected by determining if the same number is processed twice
		 * If number needs to be processed further, it gets passed back to the Process function
	 * @param processedNumber
	 */
	public void iterate(int processedNumber){		
		boolean happy = true;
		boolean unhappy = false;
		
		if (processedNumber == 1)
		{
			happiness = happy;
			finalNumber = processedNumber;
			happinessRank = intermediateNumbers.size() - 1;
		}
		
		/**
		 * Method one of catching infinite loops is hard-coded numbers that are known to be unhappy, called unhappyKnown
		 * Method two of catching infinite loops is to store each intermediate number in an arrayList
		 * If we see the same number twice, then we know that it will be stuck in an infinite loop
		 * This method is more memory intensive than the hard-coded numbers but will catch any number missing from that list
		 */
		else if (unhappyKnown.contains(processedNumber) || intermediateNumbers.contains(processedNumber))
		{
			happiness = unhappy;
			finalNumber = processedNumber;
			happinessRank = intermediateNumbers.size() - 1;
		}
		
		else
		{
			intermediateNumbers.add(processedNumber);
			isNumberHappy(processedNumber);
		}
	}	
}
