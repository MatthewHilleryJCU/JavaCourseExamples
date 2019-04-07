package com.fdm.projecteuler;

/**
 * @author matthew.hillery
 *The prime factors of 13195 are 5, 7, 13 and 29.
 *What is the largest prime factor of the number 600851475143 ?
 */
public class LargestPrime {

	public static void main(String[] args) {
//		long number = 600851475143L;
		long number = 72L;
		long x = 0;
		
		for(int i = 2; i< number; i++) {
	         while(number % i == 0&&number>i) {
	            number = number/i;
	            
	            System.out.println(i+" "+number);
	         }
	      }
	      if(number >2) {
	         x = number;
	      }
	      System.out.println(x);
	   }
	
}
