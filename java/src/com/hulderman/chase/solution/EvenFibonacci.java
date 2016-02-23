package com.hulderman.chase.solution;

public class EvenFibonacci {
	private sequenceLength;

	public EvenFibonacci(){
		this(10);
	}
	public EvenFibonacci(int num){
		setSequenceLength(num);
	}
	private int createSequence(int max) {
		return createSequence(max, max, false);
	}
	private int createSequence(int max, int select) {
		return createSequence(max, select, false);
	}
	private int createSequence(int max, int select, boolean add){
		int hold, last, lastLast;
		int num = 1;
		int count = 0; //how many times did we run?
		int sum = 0; //keep track of the sum
		boolean isEven; 

		do {
			isEven = (num % 2 == 0);
			
			if (count == 0 || count == 1){
				last = 1;
				lastLast = 1;
				num = 1;
				continue;
			}

			hold = last + lastLast;
			lastLast = last;
			last = num;
			num = hold;

			if (!add && (count == select)) {
				return num;
			}
			if (add && isEven){
				sum += num;
			}
		} while (num < max);
		return sum;
	}
	public int getFibonacciNumber(int i){
		return createSequence(i);
	}
	public int sumOfEven(int i){
		return createSequence(i, 0, true);
	}
	public void setSequenceLength(int num){
		this.sequenceLength = num;
	}
	public static void main(String[] args) {
		EvenFibonacci solution = new EvenFibonacci();
	}
}