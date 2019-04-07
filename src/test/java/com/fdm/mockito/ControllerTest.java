package com.fdm.mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

public class ControllerTest {
	private final View view = mock(View.class);
	private final Validator validator = mock(Validator.class);
	private final Controller controller = new Controller(view, validator);
	

	@Test
	public void get_user_imput_from_user_interface() {
		controller.handle();
		
		verify(view).getUserInput();
	}
	
	@Test
	public void validates_after_input_is_received() { 
		controller.handle();
		
		InOrder order = inOrder(view, validator);
		
		order.verify(view).getUserInput();
		order.verify(validator).validate(anyString());
	}
	
	@Test
	public void validates_user_input_after_it_is_received() {
		when(view.getUserInput()).thenReturn("1+1");
		
		controller.handle();
		
		InOrder order = inOrder(view, validator);
		
		order.verify(view).getUserInput();
		order.verify(validator).validate("1+1");
	}
	
		
}
