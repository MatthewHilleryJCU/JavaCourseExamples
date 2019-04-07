package com.fdm.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
/**
 *Utility class to assist reading and writing lines from specified streams.
 * 
 * @author Local.User
 */
public class FileReaderWriter {
	
	/**
	 * Writes the line provides to the provided writer.
	 * @param bw the writer to write to
	 * @param line the string to write
	 */

	public void write(BufferedWriter bw, String line) {
		try (BufferedWriter writer = bw){
			writer.write(line);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String read(BufferedReader br) {
		
		try (BufferedReader reader = br) {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
	}

}
