package com.hulderman.chase.test;

import com.hulderman.chase.solution.*;
import junit.framework.*;

/**
*	This test class tests 
*
*	@author Chase Hulderman
*	@version version 1.0 - 160223
*	@since version 1.0
*/

public class LargestPrimeTest extends TestCase {

	private LargestPrime solution;

	public void setUp() {

		solution = new LargestPrime();
	} 
	public void testSetQuery(){
		solution.setQueryNumber(5);
		assertEquals(5, solution.getQueryNumber());
	}
	public void testIsPrime() {
		assertTrue(solution.isPrime(3));
		assertFalse(solution.isPrime(4));
		assertTrue(solution.isPrime(17));
		assertFalse(solution.isPrime(18));
	}
}