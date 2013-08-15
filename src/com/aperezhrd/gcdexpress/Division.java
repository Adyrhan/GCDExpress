package com.aperezhrd.gcdexpress;

public class Division {
	private int dividend;
	private int divisor;
	private int quotient;
	private int remainder;
	
	public Division(int dividend, int divisor){
		this.dividend = dividend;
		this.divisor = divisor;
		this.quotient = dividend / divisor;
		this.remainder = dividend % divisor;
	}
	
	public int getDividend() {
		return dividend;
	}
	public int getDivisor() {
		return divisor;
	}
	public int getRemainder() {
		return remainder;
	}
	public int getQuotient() {
		return quotient;
	}

	
}
