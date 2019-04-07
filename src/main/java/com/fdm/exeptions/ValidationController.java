package com.fdm.exeptions;

public class ValidationController {

	private final Validator validator;
	private final Calculator calculator;

	public ValidationController(Validator validator, Calculator calculator) {
		this.validator = validator;
		this.calculator = calculator; 
		// TODO Auto-generated constructor stub
	}

	public void handle(String expression) {
		try {
			validator.validate(expression);
			calculator.calculate(expression);
		} catch (ValidationException e) { 
			e.printStackTrace();
		}
	}

}
