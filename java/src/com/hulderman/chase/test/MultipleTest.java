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

public class MultipleTest extends TestCase {

	private MultiplesThreeFive solution;

	public void setUp() {

		solution = new MultiplesThreeFive();
	}

	public void testFindMultiple() {
		assertEquals(23, solution.findMultipleSum(3, 5, 10));
	}
}