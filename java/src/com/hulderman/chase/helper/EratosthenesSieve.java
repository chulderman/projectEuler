package com.hulderman.chase.helper;

/**
*	Helper class EratosthenesSieve offers the Sieve of Eratosthenes algorithm.
*	
*	@author Chase Hulderman
*	@version version 1.0 - 160225
*	@since version 1.0
*/

import java.util.*;

public class EratosthenesSieve {
	/**
	*	Private class values
	*/
	private ArrayList<Integer> primeSet;
	private int maxPrimeIndex;
	private int setSize;

	/**
	*	Class constructor
	*/
	public EratosthenesSieve() {
		this(20);
	}
	public EratosthenesSieve(int n) {
		this.maxPrimeIndex = pi(n);
		this.setSize = approximatePrime(n);

		this.primeSet = this.findPrimes(this.setSize);
	}

	/**
	*	findPrimes() does what it's called.
	*
	*	@param	n			The maximum value of the set
	*	@param	fullSet		The full set of integers represented by a Binary Array of '0' for prime or '1 ' if it is a multiple
	*	@param	primeSet	The set of primes we're going to store.
	*/
	private ArrayList<Integer> findPrimes(int n){
		BitSet isMultiple = new BitSet(n);
		ArrayList<Integer> isPrime = new ArrayList<Integer>();

		//Evaluate up to sqrt(n) and so fully fillter the fullSet
		for(int i = 2; i*i <= n; i++){
			if (!isMultiple.get(i)) {
				isPrime.add(i);
				isMultiple = setMultiples(i, n, isMultiple);
			}
		}

		//Use the rest of the fullSet to finish entering primes
		for(int j = (int)Math.sqrt(n); j <= n; j++){
			if(!isMultiple.get(j)){
				isPrime.add(j);
			}
		}
		return isPrime;
	}

	/**
	*	setMultiples() is the sieve operation and filters the fullSet
	*
	*	@param	prime	The prime we're working with
	*	@param	n		The maximum value of the set
	*	@param	fullSet	This is a Binary Array that contains '0' for primes and '1' for non-primes or multiples
	*/
	private BitSet setMultiples(int prime, int n, BitSet fullSet) {
		int index;
		BitSet isMultiple = fullSet;
		for (int i = 2; i <= n/prime; i++){
			index = (i*prime);
			fullSet.set(index);
		}
		return isMultiple;
	}

	/**
	*	pi() guesses the number of primes up to some value x.
	*
	*	@param	x		Some value x to estimate up to.
	*	@return	value	Returns the number of possible primes for the provided x.
	*/
	public int pi(int x){
		int value = x / ((int)Math.log(x)-1);
		return value;
	}

	/**
	*	approximatePrime() guesses the value of the prime p(x) given some nth prime.
	*
	*	@param	x			The index or 'nth prime'
	*	@return	upperBound	Returns the upper bound of the 'guess' for the prime's value
	*/
	public int approximatePrime(int x) {
		int upperBound = x * (int)(Math.log(x) + Math.log(Math.log(x)));
		return upperBound;
	}

	/**
	*	nthPrime() guesses the value of the prime p(x) given some nth prime.
	*
	*	@param	n	the index or 'nth prime' to query
	*	@return		the value of that nth prime
	*/
	public int nthPrime(int n) {
		if (n > this.maxPrimeIndex){
			this.maxPrimeIndex = pi(n);
			this.setSize = approximatePrime(n);
			this.primeSet = this.findPrimes(this.setSize);
		}
		return this.primeSet.get(n-1).intValue();
	}

	/**
	*	printPrimes() formats and prints the full set of primes created by the sieve
	*
	*/
	public void printPrimes() {
		int max = this.primeSet.size();
		boolean interval;
		System.out.printf("Primes:\n{");
		for(int i = 0; i < max; i++){
			System.out.printf("%d",this.primeSet.get(i).intValue());
			interval = ((i+1) % 10 == 0);

			if (interval || i == max-1) { 
				System.out.printf("}\n{");
			} else {
				System.out.printf(", ");
			}
		}
		System.out.println("}");
	}
}