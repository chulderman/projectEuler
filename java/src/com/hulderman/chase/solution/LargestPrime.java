package com.hulderman.chase.solution;

import java.util.Scanner;

public class LargestPrime {
	private int queryNumber;

	public LargestPrime(int number){
		setQueryNumber(number);
	} 
	public void setQueryNumber(int number){
		this.queryNumber = number;
	}
	public int getQueryNumber() {
		return this.queryNumber;
	}
	public int evaluateLargestPrime(int query){
		int hold;

		for(int i = 1; i*i <= query; i+=2){
			if (isPrime(i)){
				hold = i;
			}
		}
		return hold;
	}
	public boolean isPrime(int num){
		
		for (int i = 2; i*i <= num; i++){
			if (num % i == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		LargestPrime solution = new LargestPrime();
		Scanner userInput = new Scanner(System.in);
		int input = 0;
		String result;

		do {
			System.out.println("Number to Test: ");
			input = userInput.nextInt();
			if (solution.isPrime(input)){
				result = " "; 
			} else {
				result = " NOT ";
			}
        	System.out.printf("The number %d is%sprime.\n", input, result);
		} while (input != -1);
	}
}