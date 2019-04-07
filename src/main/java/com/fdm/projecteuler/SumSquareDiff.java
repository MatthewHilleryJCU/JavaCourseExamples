package com.fdm.projecteuler;

/**
 * @author matthew.hillery
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 */

public class SumSquareDiff {
	
	public static void main(String[] args) {
		
		int length = 100;
		double squareSum = 0;
		double sumSquare = 0;
		
		for (int i = 1; i <= length; i++) {
			double k = Math.pow(i, 2);
			squareSum += k;
			sumSquare += i;
		}
		
		long totalDiff = (long) Math.pow(sumSquare, 2) - (long) squareSum;
		System.out.println(totalDiff);
	}
}
