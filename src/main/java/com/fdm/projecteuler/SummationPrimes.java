package com.fdm.projecteuler;

/**
 * @author Matthew.Hillery
 *	The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *	Find the sum of all the primes below two million.
 */

public class SummationPrimes {
	public static void main(String[] args) {
		SummationPrimes sp = new SummationPrimes();
		
		long sumPrimes = 2;
		int ceiling = 2000000;
//		System.out.println(System.currentTimeMillis());
		for (int i = 3; i < ceiling; i+=2) {
			if (sp.isPrime(i)) {
//				System.out.println(i);
				sumPrimes += i;
			}
		}
//		System.out.println(System.currentTimeMillis());
		System.out.println(sumPrimes);
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
