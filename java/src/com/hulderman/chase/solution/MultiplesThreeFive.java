package com.hulderman.chase.solution;

public class MultiplesThreeFive {

	private int threeAndFive;
	private int maximum;

	public MultiplesThreeFive() {
		this(1000);
	}
	public MultiplesThreeFive(int max) {
		setMax(max);
		this.threeAndFive = findMultipleSum(3, 5, this.maximum);
	}

	public int findMultipleSum(int m1, int m2, int max) {
		int sum = 0;

		for(int i = 0; i < max; i++)
		{
			if( (i % m1 == 0) || (i % m2 == 0)){
				sum += i;
			}
		}
		return sum;
	}
	public int getSolution() {
		return threeAndFive;
	}
	public int getMax() {
		return this.maximum;
	}
	public void setMax(int max) {
		this.maximum = max;
	}

	public static void main(String[] args) {
		MultiplesThreeFive solution = new MultiplesThreeFive(1000);
		System.out.printf("The sum of all multiples of 3 and 5 less than %d: %d\n", solution.getMax(), solution.getSolution());
	}
}