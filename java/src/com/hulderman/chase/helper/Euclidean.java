package com.hulderman.chase.helper;

/**
*	Helper class Euclidean offers a recursive and iterative methods of calulating the
*	greatest common denominator (factor) of two numbers using the Euclidean Algorithm. 
*
*	@author Chase Hulderman
*	@version version 1.0 - 160218
*	@since version 1.0
*/

public class Euclidean {

	private int firstNumber;
	private int secondNumber;
	private int gcd;

	public Euclidean(){
		this(0, 0);
	}
	public Euclidean(int num1, int num2){
		this.firstNumber = num1;
		this.secondNumber = num2;
	}
	public void setFirstNumber(int number){
		this.firstNumber = number;
	}
	public void setSecondNumber(int number){
		this.secondNumber = number;
	}
	public int getFirstNumber(){
		return this.firstNumber;
	}
	public int getSecondNumber(){
		return this.secondNumber;
	}
	public int getGCD(){
		return recursiveGCD(this.firstNumber, this.secondNumber);
	}
	public int getGCD(int x, int y){
		return recursiveGCD(x, y);
	}
	private int recursiveGCD(int x, int y){
		if (y == 0){
			return x;
		}else{
			int r = recursiveGCD(y, x % y);
			return r;
		}
	}
}