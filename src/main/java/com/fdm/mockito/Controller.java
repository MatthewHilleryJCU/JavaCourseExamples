package com.fdm.mockito;

public class Controller {

	private final View view;
	private final Validator validator;
	
	public Controller(View view, Validator validator) {
		this.view = view;
		this.validator = validator;
	}

	public void handle() {
		String input = view.getUserInput();
		validator.validate(input); 
	}

}
