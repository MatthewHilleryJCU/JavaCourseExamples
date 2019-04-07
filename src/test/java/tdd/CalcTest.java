package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fdm.tdd.Calc;

public class CalcTest {

	@Test
	public void when_1_plus_1_treturns_2() {
		Calc calc = new Calc();
		
		int result = calc.add(1, 1);
		
		assertEquals(2, result);
	}
	
	@Test
	public void when_1_plus_2_returns_3() {
		Calc calc = new Calc();
		
		int result = calc.add(1, 2);
		
		assertEquals(3, result);
	}
	
	@Test
	public void when_negative_1_plus_negative_1_returns_negative_2() {
		Calc calc = new Calc();
		
		int result = calc.add(-1, -1);
		
		assertEquals(-2, result);
		
	}
	
	@Test
	public void when_2_minus_1_returns_1() {
		Calc calc = new Calc();
		
		int result = calc.sub(2, 1);
		
		assertEquals(1, result);
	}

	@Test
	public void when_1_multiply_1_returns_1() {
		Calc calc = new Calc();
		
		int result = calc.multiply(1, 1);
		
		assertEquals(1, result);
	
	}
	
	@Test
	public void when_2_multiply_1_returns_2() {
		Calc calc = new Calc();
		
		int result = calc.multiply(2, 1);
		
		assertEquals(2, result);
	
	}
	
	@Test
	public void when_4_divide_2_returns_2() {
		Calc calc = new Calc();
		
		int result = calc.divide(4, 2);
		
		assertEquals(2, result);
	
	}
	
	@Test
	public void when_2_divide_1_returns_2() {
		Calc calc = new Calc();
		
		int result = calc.divide(2, 1);
		
		assertEquals(2, result);
	
	}
	@Test
	public void when_10_divide_2_returns_5() {
		Calc calc = new Calc();
		
		int result = calc.divide(10, 2);
		
		assertEquals(5, result);
	
	}
}
