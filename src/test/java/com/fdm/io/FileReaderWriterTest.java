package com.fdm.io;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import org.junit.Test;
import org.mockito.InOrder;

public class FileReaderWriterTest {
	private final FileReaderWriter frw = new FileReaderWriter();
	private final BufferedWriter bw = mock(BufferedWriter.class);
	private final BufferedReader br = mock(BufferedReader.class);

	@Test
	public void writes_line_of_characters_to_file() throws IOException {
		
		frw.write(bw, "My first line");
		
		InOrder order = inOrder(bw);
		order.verify(bw).write("My first line");
		order.verify(bw).flush();
		order.verify(bw).close();
	}
	
	@Test
	public void does_not_write_or_flush_when_exception_occurs_on_write() throws IOException {
		IOException ioException = mock(IOException.class);
		doThrow(ioException).when(bw).write("My first line");
		
		frw.write(bw, "My first line");
		verify(bw, never()).flush();
		verify(bw).close();
		verify(ioException).printStackTrace();
	}
	
	@Test
	public void reads_line_of_characters_from_file() throws IOException {
		when(br.readLine()).thenReturn("My first line");
		String readString = frw.read(br);
		
		InOrder order = inOrder(br);
		order.verify(br).readLine();
		order.verify(br).close();
		assertEquals("My first line", readString);
	}
	
	@Test
	public void closes_on_exception() throws IOException {
		IOException ioException = mock(IOException.class);
		doThrow(ioException).when(br).readLine();
		
		frw.read(br);
		verify(br).close();
		verify(ioException).printStackTrace();
		
	}

}
