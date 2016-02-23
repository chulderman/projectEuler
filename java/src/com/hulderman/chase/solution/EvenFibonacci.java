package com.hulderman.chase.solution;

import java.util.Scanner;

public class EvenFibonacci {
	private int sequenceLength;

	public EvenFibonacci(){
		this(10);
	}
	public EvenFibonacci(int num){
		setSequenceLength(num);
	}
	private int createSequence(int i) {
		int max = (int)Math.pow(2, i);
		return createSequence(max, i, false);
	}
	private int createSequence(int i, boolean add) {
		int max = (int)Math.pow(2, i);
		return createSequence(max, i, add);
	}
	private int createSequence(int max, int select, boolean add){
		int last = 1;
		int lastLast = 1;
		int num = 1;
		int count = 0; //how many times did we run?
		int sum = 0; //keep track of the sum
		boolean isEven, isSelect; 

		while (num < max) {
			isSelect = (count == select);

			if (count == 0 || count == 1){
				if(!add && isSelect){
					return num;
				}
				count++;
				continue;
			}
			lastLast = last;
			last = num;
			num = last + lastLast;
			isEven = (num % 2 == 0);
			if (add && isEven){
				sum += num;
			}
			if (!add && isSelect){
				return num;
			} else if (add && isSelect) {
				return sum;
			}
			count++;
		}
		return sum;
	}
	public int getFibonacciNumber(int i){
		return createSequence(i);
	}
	public int sumOfEven(int i){
		return createSequence(i, true);
	}
	public int sumOfEven(int max, int i){
		return createSequence(max, i, true);
	}
	public void setSequenceLength(int num){
		this.sequenceLength = num;
	}
	public static void main(String[] args) {
		EvenFibonacci solution = new EvenFibonacci();
		Scanner userInput = new Scanner(System.in);
		int input = 0;
		do {
			System.out.println("Sequence Number: ");
			input = userInput.nextInt();
        	System.out.printf("Your Number is: %d\n", solution.getFibonacciNumber(input));
		} while (input != -1);
		System.out.printf("Result: %d\n", solution.sumOfEven(4000000, -1));
	}
}