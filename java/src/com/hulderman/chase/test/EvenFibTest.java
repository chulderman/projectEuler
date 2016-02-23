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

public class EvenFibTest extends TestCase {

	private EvenFibonacci solution;

	public void setUp() {

		solution = new EvenFibonacci();
	}
	public void testGetFibonacciNumbers() {
		assertEquals(solution.getFibonacciNumber(6), solution.getFibonacciNumber(5) + solution.getFibonacciNumber(4));
	}
	public void testEvenSum(){
		assertEquals(44, solution.sumOfEven(10));
	}
}