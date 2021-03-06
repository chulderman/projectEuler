package com.hulderman.chase.solution;

public class TriplePalindrome {

	private int firstNumber, secondNumber, product;

	public TriplePalindrome() {
		findPalindrome();
	}
	public int getFirstNumber() {
		return this.firstNumber;
	}
	public int getSecondNumber() {
		return this.secondNumber;
	}
	public int getProduct() {
		return this.product;
	}
	private void findPalindrome(){
		int k;
		int pal = 0;
		int floor = 0;

		for (int i = 999; i > floor; i--){
			for(int j = 999; j > floor; j--){
				k = i*j;
				if(isPalindrome(k)){
					if (pal < k){
						pal = k;
						floor = pal/(i-1);
						break;
					}
				}
			}
		}
		this.product = pal;
	}
	private boolean isPalindrome(int query) {
		String s = Integer.toString(query);
		String reversed = reverseString(s);

		boolean evaluate = (s.equals(reversed));
		return evaluate;
	}
	private String reverseString(String input) {
		char[] output = input.toCharArray();
		int start = 0;
		int stop = input.length() - 1;
		char hold;
		while (stop > start) {
			hold = output[start];
			output[start] = output[stop];
			output[stop] = hold;
			stop--;
			start++;
		}
		return new String(output);
	}
	public static void main(String[] args) {
		TriplePalindrome solution = new TriplePalindrome();
		System.out.println("The largest palindrome made from the product of two 3-digit numbers is " + solution.getProduct());
	}
}