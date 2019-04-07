package com.fdm.travellingsanta;

import java.io.IOException;
import java.util.List;

public class SantaRun {

	public static void main(String[] args) throws IOException {
		CSVReaderCity crc = new CSVReaderCity();
		List<City> cities = crc.readCsv();
		
		for (City city : cities) {
			System.out.println(city.toString());
		}
		
		
	}
}
