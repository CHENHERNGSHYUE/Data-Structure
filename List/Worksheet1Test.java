import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/** @author 
 *  <Herng-Shyue Chen>
 * This class contains the test cases for Worksheet1 solutions.
 *  <MY TEST CASES IN BELOW>
 *  @version 2019-01-23
 */

public class Worksheet1Test {
	
	public static final double TOLERANCE = 0.00001;
	
	/**
	 * Check the different probability of combination of power
	 */
	
	@Test
	public void Exercise1() {
		
		int expectedNumber = Worksheet1.power(2,3);
		int actualNumber = Worksheet1.fastPower(2,3);

		assertEquals(expectedNumber, actualNumber, TOLERANCE);
		
		int expectedNumber2 = Worksheet1.power(2,0);
		int actualNumber2 = Worksheet1.fastPower(2,0);

		assertEquals(expectedNumber2, actualNumber2, TOLERANCE);
		
		int expectedNumber3 = Worksheet1.power(0,2);
		int actualNumber3 = Worksheet1.fastPower(0,2);

		assertEquals(expectedNumber3, actualNumber3, TOLERANCE);

	}	
	
	/**
	 * Check the positive numbers, negative numbers and 0
	 * whether would correctly change the sign symbol 
	 */
	
	@Test
	public void Exercise2() {
		
		List<Integer> L = new List(2, new List(-5, 
				new List(8, new List(0, new List()))));
		
		List<Integer> expectList = new List(-2, new List(5, 
				new List(-8, new List(0, new List()))));
		List<Integer> actualList = Worksheet1.negateAll(L);

		assertEquals(expectList, actualList);
	}
	
	/**
	 * Check whether can find the number's location, 
	 * if this number exists in the list 
	 */
	
	@Test
	public void Exercise3() {
		
		List<Integer> L = new List(7, new List(5, 
				new List(3, new List(8, new List()))));
		
		int expectIndex = 2;
		int actualIndex = Worksheet1.find(3,L);
		
		assertEquals(expectIndex, actualIndex);
	}
	
	/**
	 * Check whether can throw error, 
	 * if this number does not exist in the list 
	 */
	
	@Test(expected = IllegalArgumentException.class)
	public void Exercise31() {
		
		List<Integer> L = new List(7, new List(5, 
				new List(3, new List(8, new List()))));
		
		Worksheet1.find(2,L);	
	}
	
	/**
	 * Check whether the judgment of all positive numbers is correct
	 */
	
	@Test
	public void Exercise4() {
		
		List<Integer> L = new List(7, new List(5, 
				new List(3, new List(8, new List()))));
		List<Integer> L2 = new List(7, new List(5, 
				new List(-3, new List(8, new List()))));
		List<Integer> L3 = new List(0, new List(0, 
				new List(0, new List(0, new List()))));
		
		assertTrue(Worksheet1.allPositive(L));
		assertFalse(Worksheet1.allPositive(L2));
		assertTrue(Worksheet1.allPositive(L3));
	}
	
	/**
	 * Check whether all the positive number would be remained
	 * and all negative numbers would be removed
	 */
	
	@Test
	public void Exercise5() {
		List<Integer> L = new List(2, new List(3, 
				new List(-5, new List(8, new List(0, new List())))));
		
		List<Integer> expectList = new List(2, new List(3, 
				new List(8, new List(0, new List()))));
		List<Integer> actualList = Worksheet1.positives(L);

		assertEquals(expectList, actualList);
	}
	
	/**
	 * Check whether can correctly judge the list 
	 * is sorted in ascending order or not
	 */
	
	@Test
	public void Exercise6() {
		
		List<Integer> L = new List(2, new List(3, 
				new List(-5, new List(8, new List(0, new List())))));
		
		assertFalse(Worksheet1.sorted(L));
		
		List<Integer> L2 = new List(2, new List(3, 
				new List(5, new List(8, new List(10, new List())))));
		
		assertTrue(Worksheet1.sorted(L2));
		
		List<Integer> L3 = new List(-2, new List(-3, 
				new List(-5, new List())));
		
		assertFalse(Worksheet1.sorted(L3));

	}
	
	/**
	 * Check whether the two different sorted lists can correctly be
	 * merged to new list which is in an ascending order
	 */
	
	@Test
	public void Exercise7() {
		
		List<Integer> L = new List(2, new List(5, 
				new List(5, new List(8, new List()))));
		List<Integer> L2 = new List(5, new List(7, 
				new List(8, new List(9, new List()))));
		
		List<Integer> expectList = new List(2, new List(5, 
				new List(5, new List(5, new List(7, new List(8, 
				new List(8, new List(9, new List()))))))));
		List<Integer> actualList = Worksheet1.merge(L, L2);

		assertEquals(expectList, actualList);
		
		List<Integer> L3 = new List(9, new List());
		
		List<Integer> expectList2 = new List(2, new List(5, 
				new List(5, new List(8, new List(9, new List())))));
		List<Integer> actualList2 = Worksheet1.merge(L, L3);

		assertEquals(expectList2, actualList2);
	}
	
	/**
	 * Check whether can correctly remove the duplicate number in the list
	 */
	
	@Test
	public void Exercise8() {
		
		List<Integer> L = new List(2, new List(5, 
				new List(5, new List(5, new List(7, new List(8, 
				new List(8, new List(9, new List()))))))));
		
		List<Integer> expectList = new List(2, new List(5, 
				new List(7, new List(8, new List(9, new List())))));
		List<Integer> actualList = Worksheet1.removeDuplicates(L);

		assertEquals(expectList, actualList);

	}

}
