package com.fdm.projecteuler;

/**
 * @author matthew.hillery
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class SmallestMultiple {

	public static void main(String[] args) {
		
		int count = 0;
		int multiple = 20;
		boolean foundResult = false;
		while(!foundResult) {
			count = 0;
			for (int j = 2; j <= 20; j++) {
				if (multiple % j == 0) {
					count++;
				} else {
					break;
				}
				if (count == 19) {
					foundResult = true;
					System.out.println(multiple);
				}
			}
			multiple+=20;
		}
		System.out.println("Hello");
		
	}
}
