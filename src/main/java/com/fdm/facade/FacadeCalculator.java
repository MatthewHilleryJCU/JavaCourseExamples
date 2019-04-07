package com.fdm.facade;

public class FacadeCalculator {
	public static void main(String[] args) {
		AreaCalculator areaCalculator = new AreaCalculator();

		areaCalculator.calculateCircle();
		areaCalculator.calculateRectangle();
		areaCalculator.calculateSquare();
		
		}
	
}
