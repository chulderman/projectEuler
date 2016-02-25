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
	private BitSet fullSet;
	private ArrayList<Integer> primeSet;
	private int maxPrimeIndex;
	private int setSize;

	public EratosthenesSieve() {
		this(20);
	}
	public EratosthenesSieve(int n) {
		this.maxPrimeIndex = pi(n);
		this.setSize = approximatePrime(n);
		this.fullSet = initSets(this.setSize);

		this.findPrimes(this.setSize, this.fullSet, this.primeSet);
	}
	private BitSet initSets(int n){
		BitSet bitArray = new BitSet(n);
		bitArray.set(0,n);
		this.primeSet = new ArrayList<Integer>();
		return bitArray;
	}
	private void findPrimes(int n, BitSet fullSet, ArrayList<Integer> primeSet){

		for(int i = 2; i*i <= n; i++){
			if (fullSet.get(i)) {
				primeSet.add(i);
				clearMultiples(i, n, fullSet);
			}
		}
		for(int j = (int)Math.sqrt(n); j <= n; j++){
			if(fullSet.get(j)){
				primeSet.add(j);
			}
		}
	}
	private void clearMultiples(int prime, int n, BitSet fullSet) {
		int index;
		for (int i = 2; i <= n/prime; i++){
			index = (i*prime);
			fullSet.clear(index);
		}
	}
	public int pi(int x){
		int value = x / ((int)Math.log(x)-1);
		return value;
	}
	public int approximatePrime(int x) {
		int upperBound = x * (int)(Math.log(x) + Math.log(Math.log(x)));
		return upperBound;
	}
	public int nthPrime(int n) {
		if (n > this.maxPrimeIndex){
			this.maxPrimeIndex = pi(n);
			this.setSize = approximatePrime(n);
			this.fullSet = initSets(this.setSize);
			this.findPrimes(this.setSize, this.fullSet, this.primeSet);
		}
		return this.primeSet.get(n).intValue();
	}
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