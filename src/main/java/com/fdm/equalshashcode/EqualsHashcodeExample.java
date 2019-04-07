package com.fdm.equalshashcode;

import java.util.ArrayList;
import java.util.HashSet;

public class EqualsHashcodeExample {
	
	public static void main(String[] args) {
		HashSet<User> users = new HashSet<>();
		users.add(new User("Matt", 22));
		
		System.out.println(users.contains(new User("Matt", 22)));
		users.remove(new User("Matt", 22));
		System.out.println(users);
		
	}
}

