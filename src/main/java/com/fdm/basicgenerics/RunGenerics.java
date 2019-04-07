package com.fdm.basicgenerics;

public class RunGenerics {

	public static void main(String[] args) {
		User user = new User(100);
		
		GenericStorage<User> names = new GenericStorage<>();
		names.add(user);
		System.out.println(names.get(100));
		names.remove(100);
		System.out.println(names.get(100));
	}

}
