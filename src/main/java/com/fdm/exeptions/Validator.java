package com.fdm.exeptions;

public class Validator {

	public void validate(String expression) throws ValidationException {
		if(expression.contains("a")) {
			throw new ValidationException("Should not contain alphabetical charaters."); 
		}
		
	}

}
