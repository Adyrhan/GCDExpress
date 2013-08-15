package com.aperezhrd.gcdexpress;

import java.util.ArrayList;

public class GCD {
	private ArrayList<Division> division;
	private int gcd = 0;
	public GCD(int a, int b) {
		division = new ArrayList<Division>();
		if(a < b) calculate(b,a);
		else calculate(a,b);
	}
	private void calculate(int a, int b) {
		Division d = new Division(a, b);
		division.add(d);
		if(d.getRemainder() != 0) calculate(b, d.getRemainder());
		else 
		{
			if(division.size() == 1)
				gcd = b;
			else
				gcd = division.get(division.size()-2).getRemainder();
		}
	}
	public int getGCD() {
		return this.gcd;
	}
	public ArrayList<Division> getDivisions(){
		return this.division;
	}
}
