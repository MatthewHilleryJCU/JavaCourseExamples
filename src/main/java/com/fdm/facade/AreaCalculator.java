package com.fdm.facade;

public class AreaCalculator {
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public AreaCalculator() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
   }

	public void calculateCircle(){
		circle.calculate();
   }
	
	public void calculateRectangle(){
		rectangle.calculate();
   }
	
	public void calculateSquare(){
		square.calculate();
   }
}
