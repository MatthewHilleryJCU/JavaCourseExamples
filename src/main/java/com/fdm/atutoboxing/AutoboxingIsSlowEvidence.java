package com.fdm.atutoboxing;

public class AutoboxingIsSlowEvidence {

	public static void main(String[] args) {
		
		int[] ints = new int[1_000_000];
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < ints.length; i++) {
			ints[i] = i;
			
		}
		long end = System.currentTimeMillis();
		System.out.println("Took "+ (end-start));
		
		
		Integer[] boxing = new Integer[1_000_000];
		start = System.currentTimeMillis();
		for (int i = 0; i < boxing.length; i++) {
			boxing[i] = i;
			
		}
		end = System.currentTimeMillis();
		System.out.println("Took "+ (end-start));
		
	}
	
}
