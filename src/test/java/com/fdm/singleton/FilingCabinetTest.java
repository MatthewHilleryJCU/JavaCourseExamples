package com.fdm.singleton;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class FilingCabinetTest {
	
	@Test
	public void when_getting_two_instances_of_filing_cabinet_they_are_the_same() {
		FilingCabinet first = FilingCabinet.getInstance();
		FilingCabinet second = FilingCabinet.getInstance();
		
		assertNotNull(first);
		assertNotNull(second);
		assertSame(first, second);
	}
}
