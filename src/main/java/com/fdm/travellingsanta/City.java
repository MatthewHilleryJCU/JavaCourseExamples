package com.fdm.travellingsanta;

public class City {

	int cityID;
	double xAxis;
	double yAxis;
	boolean visited = false;
	
	public City(double x, double y, int id) {
		this.xAxis = x;
		this.yAxis = y;
		this.cityID = id;
	}

	public double getX() {
		return xAxis;
	}

	public double getY() {
		return yAxis;
	}

	public int getId() {
		return cityID;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "City [cityID=" + cityID + ", xAxis=" + xAxis + ", yAxis=" + yAxis + "]";
	}
}
