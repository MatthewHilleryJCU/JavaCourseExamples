package com.fdm.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Matthew.Hillery 28: 1,2,4,7,14,28
 */

public class TriangularNumber {

	public static void main(String[] args) {
		TriangularNumber tn = new TriangularNumber();

		int factors = 0;
		int numberToFactorise = 888;
		List<Integer> allNumbers = new ArrayList<>();
		List<Integer> allPrimes = new ArrayList<>();
		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i < numberToFactorise; i++) {
			while (numberToFactorise % i == 0 && numberToFactorise > i) {
				numberToFactorise = numberToFactorise / i;
				allNumbers.add(i);
				allNumbers.add(numberToFactorise);
				System.out.println(i + " " + numberToFactorise);
			}
		}

		for (Integer integer : allNumbers) {
			if (tn.isPrime(integer)) {
				allPrimes.add(integer);
				if (!(primes.contains(integer))) {
					primes.add(integer);
				}
			}
		}
		int count = 1;
		for (Integer integer : primes) {
			count = count * (Collections.frequency(allPrimes, integer) + 1);
			System.out.println(count);
		}
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
