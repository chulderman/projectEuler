package com.hulderman.chase.solution;


public class LargestPrime {
	private long queryNumber;
	private long result;

	public LargestPrime(){
		this(0);
	}
	public LargestPrime(long number){
		setQueryNumber(number);
		setResult(evaluateLargestPrime(getQueryNumber()));
	}
	private void setResult(long number){
		this.result = number;
	}
	public long getResult(){
		return this.result;
	}
	public void setQueryNumber(long number){
		this.queryNumber = number;
	}
	public long getQueryNumber() {
		return this.queryNumber;
	}
	private long evaluateLargestPrime(long query){
		long hold = 1;
		for(long i = 1; i <= query; i+=2){
			if (query % i == 0) {
				query /= i;
				if (isPrime(i)){
					hold = i;
				}
			}
		}
		return hold;
	}
	public long fermatFactor(long num){
		long a = (long)Math.ceil(Math.sqrt(num));
		long b2 = (a*a) - num;
		while (!(Math.sqrt(b2) == Math.floor(Math.sqrt(b2))))
		{
			a++;
			b2 = (a*a) - num;
		}
		return a + (long)Math.sqrt(b2);
	}
	public boolean isPrime(long num){
		
		for (long i = 2; i*i <= num; i++){
			if (num % i == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		LargestPrime solution = new LargestPrime(600851475143L);
		
		System.out.printf("The largest prime number of %d is %d\n", solution.getQueryNumber(), solution.getResult());
	}
}