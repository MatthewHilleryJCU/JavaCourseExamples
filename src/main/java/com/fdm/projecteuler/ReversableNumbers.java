package com.fdm.projecteuler;

/**
 * @author Matthew.Hillery Some positive integers n have the property that the
 *         sum [ n + reverse(n) ] consists entirely of odd (decimal) digits. For
 *         instance, 36 + 63 = 99 and 409 + 904 = 1313. We will call such
 *         numbers reversible; so 36, 63, 409, and 904 are reversible. Leading
 *         zeroes are not allowed in either n or reverse(n). There are 120
 *         reversible numbers below one-thousand. How many reversible numbers
 *         are there below one-billion (109)?
 */
public class ReversableNumbers {
	public static void main(String[] args) {
		ReversableNumbers rn = new ReversableNumbers();
		int ceiling = 1000000000;
		int reversableCount = 0;
		int reversedNum = 0;
		long start = System.currentTimeMillis();
		for (int i = 1; i < ceiling; i++) {
			if (i % 10 == 0) {

			} else {
				reversedNum = rn.reverse(i);
				if (rn.isReversable(i, reversedNum)) {
					reversableCount++;
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(reversableCount);
	}

	private boolean isReversable(int i, int revesedNum) {
		int x = i + revesedNum;
		String str = String.valueOf(x);
		int count = 0;
		for (int j = str.length() - 1; j >= 0; j--) {
			if (!((int) str.charAt(j) % 2 == 0)) {
				count++;
			}
		}
		if (count == str.length()) {
//			System.out.println(x + " " + i + "+" + revesedNum);
			return true;
		} else {
			return false;
		}

	}

	private int reverse(int i) {
		char[] str = String.valueOf(i).toCharArray();
		char[] reverse = new char[str.length];
		for (int j = 0; j < str.length; j++) {
			reverse[str.length-j-1] = str[j];
		}
		return Integer.parseInt(String.valueOf(reverse));
	}
}
