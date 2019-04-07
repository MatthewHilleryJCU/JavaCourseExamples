package com.fdm.travellingsanta;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;


public class CSVReaderCity {
	
	public List<City> readCsv() throws IOException {
		
		CityFactory factory = new CityFactory();
		Reader fileReader = new FileReader("./src/main/resources/cities.csv");
		
		CSVReader reader = new CSVReader(fileReader);
		
		List<City> allCities = new ArrayList<City>();

		// read line by line
		String[] record = null;

		while ((record = reader.readNext()) != null) {
			City city = factory.create(Double.valueOf(record[1]), Double.valueOf(record[2]), Integer.valueOf(record[0]));
			
			allCities.add(city);
		}
		reader.close();
		return allCities;
	}
	
}
