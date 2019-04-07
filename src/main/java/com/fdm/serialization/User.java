package com.fdm.serialization;

public class User {
	private final String username;
	private final int age;
	private final Portfolio portfolio;
	
	public User(String username, int age, Portfolio portfolio) {
		super();
		this.username = username;
		this.age = age;
		this.portfolio = portfolio;
	}

	public String getUsername() {
		return username;
	}

	public int getAge() {
		return age;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}
	
}

