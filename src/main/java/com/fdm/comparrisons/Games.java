package com.fdm.comparrisons;

public class Games implements Comparable<Games>{
	private String name;
	private float price;
	private int score100;
	
	public Games(String name, float price, int score100) {
		super();
		this.name = name;
		this.price = price;
		this.score100 = score100;
	}

	@Override
	public String toString() {
		return "Games [name=" + name + ", price=" + price + ", score100=" + score100 + "]";
	}
 
	@Override
	public int compareTo(Games other) {
		int comp = this.name.compareTo(other.name);
		if(comp != 0)				
			return comp;
		double priceDiff = this.price - other.price;
		if (Math.abs(priceDiff) >= 1.0) {
			return (int)priceDiff;
		}
		return this.score100 - other.score100;
	}
	
	

	
}
