package com.fdm.exeptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ValidatorTest {  

	@Test(expected=ValidationException.class)
	public void throws_error_when_string_contains_letter_a() throws ValidationException {
		Validator validator = new Validator();
		
		validator.validate("a+2");
	}
	
	@Test
	public void has_correct_error_message_on_exception() {
		Validator validator = new Validator();
		
		try {
			validator.validate("a+2");
			fail();
		} catch (ValidationException e) {
			assertEquals("Should not contain alphabetical charaters.", e.getMessage());
		}
	}
	
	
	@Test 
	public void no_error_occurs_when_excpression_is_valid() {
		Validator validator = new Validator();
		
		assertNoException(validator, "1+2");
	}


	private void assertNoException(Validator validator, String expression) {
		try {
			validator.validate(expression);
		} catch (ValidationException e) {
			fail("Expected no exceptions but Validation Occured");
		}
	}
	
	    
}
