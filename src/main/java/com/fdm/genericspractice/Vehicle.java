package com.fdm.genericspractice;

public class Vehicle implements Storable {

	private final String name;
	
	public Vehicle (String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}


}
