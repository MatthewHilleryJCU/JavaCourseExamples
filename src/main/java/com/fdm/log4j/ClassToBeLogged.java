package com.fdm.log4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class ClassToBeLogged {
	public static void main(String[] args) {
		ClassToBeLogged loggExample = new ClassToBeLogged();
		try {
			loggExample.fileIO();
		
		} catch (Throwable t) {
			loggExample.logger.fatal("Fatal error occurs : ", t);
			throw t;
		}
	
		
	}
	
	private Logger logger = Logger.getLogger(ClassToBeLogged.class);
	
	private void fileIO() {
		logger.trace("In fileIO method");
		try {
			logger.trace("In try block");
			FileWriter fw = new FileWriter("C:\\Users\\local.user\\file.txt");
			logger.debug(fw);
			BufferedWriter writer = new BufferedWriter(fw);
			logger.debug(writer);
			if (writer == null) 
				logger.warn("Null object may effect downsteam " + writer);
			writer.write("Hello world.");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.trace("in catch block");
			logger.error("Unable to write to file: ", e);
		}
	}
}
