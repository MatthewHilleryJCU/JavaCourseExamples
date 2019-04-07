package com.fdm.interfaces;

public interface Animal {
	void move();

	default void getAnimalType() {
		System.out.println(this.getClass());
	}
}
