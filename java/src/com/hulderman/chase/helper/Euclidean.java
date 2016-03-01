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
	/**
	*	Private class values
	*/
	private int firstNumber;
	private int secondNumber;
	private int gcd;

	/**
	*	Class constructor
	*/
	public Euclidean(){
		this(0, 0);
	}
	public Euclidean(int num1, int num2){
		this.firstNumber = num1;
		this.secondNumber = num2;
	}

	/**
	*	Simple mutator methods
	*/
	public void setFirstNumber(int number){
		this.firstNumber = number;
	}
	public void setSecondNumber(int number){
		this.secondNumber = number;
	}
	
	/**
	*	Simple accessor methods
	*/
	public int getFirstNumber(){
		return this.firstNumber;
	}
	public int getSecondNumber(){
		return this.secondNumber;
	}
	
	/**
	*	getGCD() returns the greatest common divider.
	*
	*	@param	choose	TRUE for the recursive method or FALSE for the iterative method
	*	@return	gcd	the greatest common denominator (factor) of x and y
	*/
	public int getGCD(boolean choose){
		int gcd;
		if (choose){
			gcd = recursiveGCD(this.firstNumber, this.secondNumber);
		} else {
			gcd = iterativeGCD(this.firstNumber, this.secondNumber);
		}
		return gcd;
	}

	/**
	*	recursiveGCD() is the recursive Euclidean algorithm.
	*
	*	@param	x	some first integer
	*	@param	y	some second integer
	*	@return	r	the greatest common denominator (factor) of x and y
	*/
	private int recursiveGCD(int x, int y){
		if (y == 0){
			return x;
		}else{
			int r = recursiveGCD(y, x % y);
			return r;
		}
	}

	/**
	*	iterativeGCD() is the recursive Euclidean algorithm.
	*
	*	@param	x	some first integer
	*	@param	y	some second integer
	*	@return	x	the greatest common denominator (factor) of x and y
	*/
	private int iterativeGCD(int x, int y){
		while (y != 0){
			int r = x % y;
			x = y;
			y = r;
		}
		return x;
	}
}