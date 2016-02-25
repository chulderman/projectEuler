package com.hulderman.chase.solution;

public class SumSquares {
	private int seqSquare,numSquare, difference, maxNumber;
	
	public SumSquares() {
		this(10);
	}
	public SumSquares(int max) {
		this.maxNumber = max;
		this.numSquare = naturalNumbers(this.maxNumber, 1);
		this.seqSquare = naturalNumbers(this.maxNumber, 0);
		this.difference = this.seqSquare - this.numSquare;
	}
	private int naturalNumbers(int max, int pos) {
		int[] results = {0, 0};
		boolean select = (pos == 1) ? true : false;
		for (int i = 1; i <= max; i++){
			if(select) {
				results[pos] += i*i;
			} else {
				results[pos] += i;
			}
		}
		results[pos] *= (select) ? 1 : results[pos];
		return results[pos];
	}
	public int getSeqSquare() {
		return this.seqSquare;
	}
	public int getNumSquare() {
		return this.numSquare;
	}
	public int getDifference() {
		return this.difference;
	}
	public int getMaxNumber() {
		return this.maxNumber;
	}
	public static void main(String[] args) {
		SumSquares solution = new SumSquares(100);
		System.out.printf("The difference of %d and %d is %d\n", solution.getSeqSquare(), solution.getNumSquare(), solution.getDifference());
	}
}