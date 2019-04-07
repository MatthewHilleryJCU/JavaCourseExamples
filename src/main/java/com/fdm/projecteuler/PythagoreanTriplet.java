package com.fdm.projecteuler;

/**
 * @author Matthew.Hillery
 *
 *	A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * 	a2 + b2 = c2
 * 	For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * 	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * 	Find the product abc.
 *
 */

public class PythagoreanTriplet {
	
	public static void main(String[] args) {
		
		double number = 1000.0;
		for (int i = 0; i < 20000; i++) {
			for (int j = 0; j < 20000; j++) {
				int c = (i*i) + (j*j);
				double x = Math.sqrt(c);
				if (x + i + j == number) {
					System.out.println(i*j*(int)x);
					break;
				}
			}
		}
		
	}
}
