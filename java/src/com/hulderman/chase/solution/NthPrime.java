package com.hulderman.chase.solution;

import com.hulderman.chase.helper.EratosthenesSieve;

public class NthPrime {
	public static void main(String[] args) {
		EratosthenesSieve solution = new EratosthenesSieve();
		System.out.println("Solution: " + solution.nthPrime(10001));
	}
}