package com.hulderman.chase.solution;

public class SmallestMultiple {
	private int result;

	public SmallestMultiple(){
		this.result = evaluateNumbers();

	}
	public int getResult(){
		return this.result;
	}
	private int evaluateNumbers(){
		int query = 20;
		while(!doesDivide(query, 20)){
			query++;
		}
		return query;
	}
	private boolean doesDivide(int q, int d){
		for (int i = d; i > 0; i--){
			if ((q % i) == 0){
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		SmallestMultiple solution = new SmallestMultiple();
		System.out.print("The smallest number that can be divided by each of the numbers from 1 to 10 without any remainder: ");
		System.out.println(solution.getResult());
	}
}