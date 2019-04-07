package com.fdm.genericspractice;

import com.fdm.basicgenerics.GenericStorage;
import com.fdm.basicgenerics.User;

public class RunGenericsPractice {

	public static void main(String[] args) {
		Vehicle vehical = new Vehicle("Ok");
		
		GenericStorage<Vehicle> names = new GenericStorage<>();
		names.add(vehical);
		System.out.println(names.get(100));
		names.remove(100);
		System.out.println(names.get(100));
	

	}

}
