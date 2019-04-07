package com.fdm.projecteuler;

/**
 * @author matthew.hillery 
 * 			A palindromic number reads the same both ways. The
 *         largest palindrome made from the product of two 2-digit numbers is
 *         9009 = 91 × 99. Find the largest palindrome made from the product of
 *         two 3-digit numbers.
 */
public class PalindromNumbers {

	public static void main(String[] args) {
		
		PalindromNumbers pn = new PalindromNumbers();
		int largestNum = 0;

		for (int j = 99; j < 1000; j++) {
			for (int z = 99; z < 1000; z++) {
				if (pn.isPalan(z * j)) {
					if (largestNum < (z * j)) {
						largestNum = (z * j);
					};
//					largestNum = (z * j);
				}
			}
		}
		
		System.out.println(largestNum);
	}

	private boolean isPalan(int i) {
		int k = 0;
		String str = String.valueOf(i);
		String reverse = "";
		for (int j = str.length() - 1; j >= 0; j--) {
			reverse = reverse + str.charAt(j);
		}

		if (Integer.valueOf(reverse) == i) {
			return true;
		}
		return false;
	}
}
