package com.fdm.memory;

public class ListmusTest {
	
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		swap(a, b);
		System.out.println("A is "+a+", B is "+b);
		
		TwoInts twoInts = new TwoInts();
		twoInts.a = 1;
		twoInts.b = 2;
		swap(twoInts);
		System.out.println("A is "+twoInts.a+", B is "+twoInts.b);
		
	
	}
	
	private static class TwoInts {
		int a, b;
		
	}
	
	private static void swap(TwoInts twoInts) {
		int temp = twoInts.a;
		twoInts.a = twoInts.b;
		twoInts.b = temp;
	}
	
	private static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
}
