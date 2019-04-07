package com.fdm.basicgenerics;

import java.util.ArrayList;

public class GenericStorage<T extends Storable> {

	private final ArrayList<T> values = new ArrayList<>();

	public void add(T type) {
		values.add(type);
	}

	public T get(int id) {
		for (T type : values) {
			if (type.getId() == id) {
				return type;
			}
		}
		return null;
	}

	public void remove(int id) {
		T remove = null;
		for (T type : values) {
			if (type.getId() == id) {
				remove = type;
				break;
			}
		}
		values.remove(remove);
	}
}
