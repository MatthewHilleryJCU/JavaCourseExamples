package com.fdm.jdbc.jpa;

public interface Persistable <T> {
	int getId();
	void update(T updateType);
	
}
