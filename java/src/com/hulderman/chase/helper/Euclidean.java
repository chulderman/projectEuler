package com.hulderman.chase.helper;

import java.util.Scanner;

public class Euclidean {

	private Scanner userInput;
	private int firstNumber;
	private int secondNumber;
	private int gcd;

	public Euclidean(){
		this.userInput = new Scanner(System.in);
		System.out.println("First Number: ");
        setFirstNumber(userInput.nextInt());
        System.out.println("Second Number: ");
        setSecondNumber(userInput.nextInt());
	}
	public Euclidean(int num1, int num2){
		setFirstNumber(num1);
		setSecondNumber(num2);
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
		return calcGCD(this.firstNumber, this.secondNumber);
	}
	public int getGCD(int x, int y){
		return calcGCD(x, y);
	}
	private int calcGCD(int x, int y){
		if (y == 0){
			return x;
		}else{
			int r = calcGCD(y, x % y);
			return r;
		}
	}
	public static void main(String[] args) {
		Euclidean euclid = new Euclidean();
		System.out.printf("GCD of %d and %d is %d\n", euclid.getFirstNumber(), euclid.getSecondNumber(), euclid.getGCD());
	}
}