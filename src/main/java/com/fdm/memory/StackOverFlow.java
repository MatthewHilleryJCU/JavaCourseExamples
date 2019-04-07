package com.fdm.memory;

public class StackOverFlow {

	public static void main(String[] args) {
		StackOverFlow so = new StackOverFlow();
		System.out.println(so.add(1));
		

	}

	public int add(int i) {
		if(i == 1000) {
			return i;
		}
		return add(++i) + i;
	}
}
