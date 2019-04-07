package com.fdm.memory;

import java.util.ArrayList;

public class HeapOutOfMemory {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = 0; i >= 0; i++) {
			numbers.add(i);
			
		}
	}
}
