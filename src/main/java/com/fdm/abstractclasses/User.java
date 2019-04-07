package com.fdm.abstractclasses;

public abstract class User {

	private String username;

	public abstract void login();

	public final String getUnsername() {
		return username;

	}

	public final void setUserName(String username) {
		this.username = username;
	}

}
