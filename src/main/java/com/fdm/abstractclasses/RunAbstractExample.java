package com.fdm.abstractclasses;

public class RunAbstractExample {
	
	public static void main(String[] args) {
		User user = new Admin();
		user.getUnsername();
		user.login();
		
		User user2 = new EverydayUser();
		user2.login();
	}
}
