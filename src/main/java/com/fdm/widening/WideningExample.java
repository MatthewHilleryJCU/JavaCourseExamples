package com.fdm.widening;

public class WideningExample {
	
	public static void main(String[] args) {
		WideningExample we = new WideningExample();
		we.widen( (byte) 10);
	}

	private void widen(short s) {
		System.out.println("is short");
	}
	
	private void widen(byte b) {
		System.out.println("is byte");
	}
	
}
