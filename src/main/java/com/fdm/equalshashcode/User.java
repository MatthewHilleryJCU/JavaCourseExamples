package com.fdm.equalshashcode;

import static org.junit.Assert.assertNotNull;

public class User {
	
	private String userName;
	private int age;
	
	public User (String userName, int age) {
		this.userName = userName;
		this.age = age;
		
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} 
		return userName.equals(other.userName);
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	

	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + "]";
	}
	
	
}
