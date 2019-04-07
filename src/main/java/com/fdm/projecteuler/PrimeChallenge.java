package com.fdm.projecteuler;

/**
 * @author Matthew.Hillery
 * 	 	10001st prime
 * 		By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * 		What is the 10 001st prime number?
 */

public class PrimeChallenge {
	public static void main(String[] args) {
		PrimeChallenge pc = new PrimeChallenge();
		int number = 10000000;
		int prime = 0;
		boolean flag = false;
		int num = 2;
		int count = 0;
		
		while (!flag) {
			if (pc.isPrime(num)) {
				prime = num;
				System.out.println(prime);
				count++;
			}
			num++;
			if (count == 10001) {
				flag = true;
			}
		}
		System.out.println(prime);
	}
	
	private boolean isPrime(int n) {
	    if (n == 2) {
	    	return true;
	    }
	    if (n == 3) {
	    	return true;
	    }
	    if (n % 2 == 0) {
	    	return false;
	    }
	    if (n % 3 == 0) {
	    	return false;
	    }
	    int i = 5;
	    int w = 2;
	    
	    while (i * i <= n) {
			if (n % i == 0) {
				return false;
			}
			i += w;
			w = 6 - w;
		}
	    return true;
	}
}
