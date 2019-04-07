package com.fdm.exeptions;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class ValidationControllerTest { 
	private final Validator validator = mock(Validator.class);
	private final Calculator calculator = mock(Calculator.class);
	private final ValidationController controller = new ValidationController(validator, calculator);

	@Test
	public void when_expression_is_calculated_when_is_valid() throws ValidationException {

		controller.handle("1+1");

		verify(validator).validate("1+1");
		verify(calculator).calculate("1+1");

	}
	

	@Test
	public void exp_is_not_calculated_when_is_not_valid_and_prints_error_message() throws ValidationException {

		ValidationException ve = mock(ValidationException.class);
		doThrow(ve).when(validator).validate("a+1");
		
		controller.handle("a+1");
		
		verify(validator).validate("a+1");
		verify(calculator, never()).calculate("a+1");
		verify(ve).printStackTrace();
	}
}
