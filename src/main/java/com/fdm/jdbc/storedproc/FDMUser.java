package com.fdm.jdbc.storedproc;

public class FDMUser {
	
	private int id;
	private String name;

	public FDMUser(int id, String name) {
		this.id = id;
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FDMUser [id=" + id + ", name=" + name + "]";
	}

	

}
