package com.fdm.genericspractice;

import java.util.ArrayList;

public class GenericStorage<T extends Storable> {

	private final ArrayList<T> values = new ArrayList<>();

	public void add(T type) {
		values.add(type);
	}

	public T get(String name) {
		for (T type : values) {
			if (type.getName() == name) {
				return type;
			}
		}
		return null;
	}

	public void remove(String name) {
		T remove = null;
		for (T type : values) {
			if (type.getName() == name) {
				remove = type;
				break;
			}
		}
		values.remove(remove);
	}
}
