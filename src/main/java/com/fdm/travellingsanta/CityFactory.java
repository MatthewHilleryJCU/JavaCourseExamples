package com.fdm.travellingsanta;

public class CityFactory {

	public City create(double x, double y, int id) {
		return new City(x, y, id);
	}
}
