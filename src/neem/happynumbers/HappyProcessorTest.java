package neem.happynumbers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HappyProcessorTest {
	boolean happy = true;
	boolean unhappy = false;
	
	@Test
	public final void testHappyProcessor() {
		//test correct initialization of variables in class
		int inputNumber = 15790;
		HappyProcessor testObject = new HappyProcessor(inputNumber);
		
		int processNumberTest = testObject.processNumber;
		assertNotNull(processNumberTest);
		assertEquals(inputNumber, processNumberTest);
	}

	@Test
	public final void testGetHappy() {
		//test that when the number is happy, it gives correct statement
		HappyProcessor testObject = new HappyProcessor(15780);
		testObject.isNumberHappy(15780);
		boolean testHappy = testObject.getHappy();
		assertEquals(happy, testHappy);
	}
	
	@Test
	public final void testGetHappy2() {
		//test that when the number is unhappy, it gives correct statement
		HappyProcessor testObject = new HappyProcessor(15790);
		testObject.isNumberHappy(15790);
		boolean testHappy = testObject.getHappy();
		assertEquals(unhappy, testHappy);
	}
	
	@Test
	public final void testGetIntermediateNumbers() {
		//test that the first number input in the IntermediateNumbers list is the input number
		int testInput = 15790;
		HappyProcessor testObject = new HappyProcessor(testInput);
		
		List<Integer> intermediateNumbersArray = new ArrayList<Integer>();
		intermediateNumbersArray.add(15790);
		
		List<Integer> intermediateNumbersTestArray = new ArrayList<Integer>();
		intermediateNumbersTestArray = testObject.getIntermediateNumbers();
		
		assertNotNull(intermediateNumbersTestArray);
		assertEquals(intermediateNumbersArray, intermediateNumbersTestArray);
	}
	
	@Test
	public final void testGetIntermediateNumbers2() {
		//process a number and then assess that it has the correct intermediate numbers in the arrayList
		int testInput = 15790;
		HappyProcessor testObject = new HappyProcessor(testInput);
		
		List<Integer> intermediateNumbersArray = new ArrayList<Integer>();
		intermediateNumbersArray.add(15790);
		
		List<Integer> intermediateNumbersTestArray = new ArrayList<Integer>();
		intermediateNumbersTestArray = testObject.getIntermediateNumbers();
		
		testObject.isNumberHappy(testInput);
		intermediateNumbersArray.add(156);
		intermediateNumbersArray.add(62);
		intermediateNumbersArray.add(40);
		
		intermediateNumbersTestArray = testObject.getIntermediateNumbers();
		
		assertNotNull(intermediateNumbersTestArray);
		assertEquals(intermediateNumbersArray, intermediateNumbersTestArray);		
	}
	
	@Test
	public final void testGetFinalNumber() {
		//test that when we hit the final number to base happiness off of, we can output the number
		int testInput = 15790;
		HappyProcessor testObject = new HappyProcessor(testInput);
		
		//checks to make sure that initial final number is 0
		int finalNumber = 0;
		int finalNumberTest = testObject.getFinalNumber();
		assertNotNull(finalNumberTest);
		assertEquals(finalNumber, finalNumberTest);
	}
		
	@Test
	public final void testGetFinalNumber1() {
		//checks to make sure that final number after processing is correct (unhappy number)
		int testInput = 15790;
		HappyProcessor testObject = new HappyProcessor(testInput);
		
		testObject.isNumberHappy(testInput);
		int finalNumberTest = testObject.getFinalNumber();
		int finalNumber = 16;
		assertNotNull(finalNumberTest);
		assertEquals(finalNumber, finalNumberTest);
	}	
		
	@Test
	public final void testGetFinalNumber2() {
		//checks to make sure that final number after processing is correct (happy number)
		int testInput = 15780;
		HappyProcessor testObject2 = new HappyProcessor(testInput);
		
		testObject2.isNumberHappy(testInput);
		int finalNumberTest = testObject2.getFinalNumber();
		int finalNumber = 1;
		assertNotNull(finalNumberTest);
		assertEquals(finalNumber, finalNumberTest);
	}

	@Test
	public final void testProcess() {
		//test that if you give it a number, it gives you either the happy number or one of the unhappy ones
		
		//unhappy number
		HappyProcessor testObject = new HappyProcessor(0);
		testObject.isNumberHappy(0);
		boolean testObjectHappy = testObject.getHappy();
		
		assertNotNull(testObjectHappy);
		assertEquals(unhappy, testObjectHappy);		
		
		int knownHappyRank = 0;
		int testHappyRank = testObject.getHappinessRank();
		
		assertNotNull(testHappyRank);
		assertEquals(knownHappyRank, testHappyRank);
	}	
		
		@Test
		public final void testProcess2() {
		//happy number
		HappyProcessor testObject2 = new HappyProcessor(1);
		testObject2.isNumberHappy(1);
		boolean testObject2Happy = testObject2.getHappy();
		
		assertNotNull(testObject2Happy);
		assertEquals(happy, testObject2Happy);
		
		int knownHappyRank2 = 0;
		int testHappyRank2 = testObject2.getHappinessRank();
		
		assertNotNull(testHappyRank2);
		assertEquals(knownHappyRank2, testHappyRank2);	
	}
		
	@Test
	public final void testProcess3() {
		//unhappy number (final number is 4 which is unhappy)
		HappyProcessor testObject3 = new HappyProcessor(150);
		testObject3.isNumberHappy(150);
		boolean testObject3Happy = testObject3.getHappy();
		
		assertNotNull(testObject3Happy);
		assertEquals(unhappy, testObject3Happy);
		
		int knownHappyRank3 = 2;
		int testHappyRank3 = testObject3.getHappinessRank();
	
		assertNotNull(testHappyRank3);
		assertEquals(knownHappyRank3, testHappyRank3);
	}
		
	@Test
	public final void testProcess4() {
		//happy number
		HappyProcessor testObject4 = new HappyProcessor(15780);
		testObject4.isNumberHappy(15780);
		boolean testObject4Happy = testObject4.getHappy();
		
		assertNotNull(testObject4Happy);
		assertEquals(happy, testObject4Happy);
		
		int knownHappyRank4 = 5;
		int testHappyRank4 = testObject4.getHappinessRank();
		
		assertNotNull(testHappyRank4);
		assertEquals(knownHappyRank4, testHappyRank4);
	}

	@Test
	public final void testParse() {
		//input a number, output it parsed into digits, backwards
		HappyProcessor testObject = new HappyProcessor(15790);
		
		List<Integer> parsedNumbers = new ArrayList<Integer>();
		parsedNumbers.add(0);
		parsedNumbers.add(9);
		parsedNumbers.add(7);
		parsedNumbers.add(5);
		parsedNumbers.add(1);
		
		List<Integer> parsedTestArray = new ArrayList<Integer>();
		parsedTestArray = testObject.parse(15790);
		
		assertNotNull(parsedTestArray);
		assertEquals(parsedNumbers, parsedTestArray);
	}

	@Test
	public final void testSquare() {
		//input an array, make sure it squares each value in array
		List<Integer> squareTestArray = new ArrayList<Integer>();
		squareTestArray.add(0);
		squareTestArray.add(1);
		squareTestArray.add(5);
		squareTestArray.add(7);
		squareTestArray.add(9);
		
		List<Integer> squaredNumbers = new ArrayList<Integer>();
		squaredNumbers.add(0*0);
		squaredNumbers.add(1*1);
		squaredNumbers.add(5*5);
		squaredNumbers.add(7*7);
		squaredNumbers.add(9*9);
		
		HappyProcessor testObject = new HappyProcessor(15790);
		
		testObject.square(squareTestArray);
		
		assertNotNull(squareTestArray);
		assertEquals(squaredNumbers, squareTestArray);
	}

	@Test
	public final void testAdd() {
		//input an array into add function, test that it adds all values in array together
		List<Integer> addTestArray = new ArrayList<Integer>();
		addTestArray.add(0);
		addTestArray.add(1);
		addTestArray.add(25);
		addTestArray.add(49);
		addTestArray.add(81);
		
		int addedValue = 0 + 1 + 25 + 49 + 81;
		
		HappyProcessor testObject = new HappyProcessor(15790);
		
		int returnVal = testObject.add(addTestArray);
		
		assertNotNull(returnVal);
		assertEquals(addedValue, returnVal);
	}

	@Test
	public final void testIterate() {
		//input a happy number, tests that it iterates out to a happy number with a final number of 1
		int happyNumber = 15780;
		int finalHappy = 1;
		int inputAtIterate = 139;
		HappyProcessor testObject = new HappyProcessor(happyNumber);
		testObject.iterate(inputAtIterate);
		
		boolean happy = true;
		assertNotNull(testObject.getHappy());
		assertEquals(happy, testObject.getHappy());
		
		assertNotNull(testObject.getFinalNumber());
		assertEquals(finalHappy, testObject.getFinalNumber());
	}	
	
	@Test
	public final void testIterate2() {		
		//input a unhappy number, test that it changes happiness to unhappy
		int unhappyNumber = 15790;
		int finalUnhappy = 16;
		int inputAtIterate = 156;
		HappyProcessor testObject2 = new HappyProcessor(unhappyNumber);
		testObject2.iterate(inputAtIterate);
		
		boolean unhappy = false;
		assertNotNull(testObject2.getHappy());
		assertEquals(unhappy, testObject2.getHappy());
		
		assertNotNull(testObject2.getFinalNumber());
		assertEquals(finalUnhappy, testObject2.getFinalNumber());
		
	}

}
