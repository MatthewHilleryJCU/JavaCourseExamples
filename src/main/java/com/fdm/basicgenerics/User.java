package com.fdm.basicgenerics;

public class User implements Storable {

	private final int id;
	
	public User(int id) {
		this.id = id;
	}
	
	@Override
	public int getId() {
		return id;
	}

}
