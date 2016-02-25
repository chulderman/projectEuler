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
	private BitSet fullSet;
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
		this.fullSet = initSets(this.setSize);

		this.findPrimes(this.setSize, this.fullSet, this.primeSet);
	}

	/**
	*	initSets() initializes the sets given some maximum value.
	*
	*	@param	n			The maximum value of the set
	*	@return	bitArray	A BitSet fully initialized
	*/	
	private BitSet initSets(int n){
		BitSet bitArray = new BitSet(n);
		bitArray.set(0,n);
		this.primeSet = new ArrayList<Integer>();
		return bitArray;
	}

	/**
	*	findPrimes() does what it's called.
	*
	*	@param	n			The maximum value of the set
	*	@param	fullSet		The full set of integers represented by a Binary Array of '1' for prime or '0 ' if it is a multiple
	*	@param	primeSet	The set of primes we're going to store.
	*/
	private void findPrimes(int n, BitSet fullSet, ArrayList<Integer> primeSet){

		//Evaluate up to sqrt(n) and so fully fillter the fullSet
		for(int i = 2; i*i <= n; i++){
			if (fullSet.get(i)) {
				primeSet.add(i);
				clearMultiples(i, n, fullSet);
			}
		}

		//Use the rest of the fullSet to finish entering primes
		for(int j = (int)Math.sqrt(n); j <= n; j++){
			if(fullSet.get(j)){
				primeSet.add(j);
			}
		}
	}

	/**
	*	clearMultiples() is the sieve operation and filters the fullSet
	*
	*	@param	prime	The prime we're working with
	*	@param	n		The maximum value of the set
	*	@param	fullSet	This is a Binary Array that contains '1' for primes and '0' for non-primes or multiples
	*/
	private void clearMultiples(int prime, int n, BitSet fullSet) {
		int index;
		for (int i = 2; i <= n/prime; i++){
			index = (i*prime);
			fullSet.clear(index);
		}
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
			this.fullSet = initSets(this.setSize);
			this.findPrimes(this.setSize, this.fullSet, this.primeSet);
		}
		return this.primeSet.get(n).intValue();
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