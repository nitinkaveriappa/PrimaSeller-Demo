package com.primaseller.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.primaseller.model.Onward;
import com.primaseller.model.Sale;

public class SalesUtil {
	/** 
	    * This method parses the sales.list csv file. 
	    * @param filename The path\filname of Sales CSV. 
	    * @return sales List of Sales . 
	 */
	public static List<Sale> readSalesFromCSV(String fileName) { 
		List<Sale> sales = new ArrayList<>(); 
		Path pathToFile = Paths.get(fileName); 
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
			String line = br.readLine(); 
			while (line != null) { 
				String[] attributes = line.split(","); 
				Sale sale = createSale(attributes); 
				sales.add(sale); 
				line = br.readLine();
			} 
		} catch (IOException ioe) { 
			ioe.printStackTrace(); 
			} 
		return sales; 
	} 
	/** 
	    * This method creates new Sale objects from the csv data . 
	    * @param metadata String array of single row in the csv file. 
	    * @return Sale Sale object created. 
	 */
	private static Sale createSale(String[] metadata) { 
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sale_date = null;
		try {
			sale_date = format.parse(metadata[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String sale_email = metadata[1];
		String sale_payment_method = metadata[2];
		int sale_item_count = Integer.parseInt(metadata[3]);
		List<Onward> onwards = new ArrayList<>();
		for(int i = 4; i<metadata.length; i++) {
			String[] on = metadata[i].split(";");
			Onward onward = createOnward(on);
			onwards.add(onward);
		}
		
		return new Sale(sale_date, sale_email, sale_payment_method, sale_item_count, onwards); 
	}
	
	private static Onward createOnward(String[] metadata) {
		String book_id = metadata[0];
		int quantity_purchased = Integer.parseInt(metadata[1]);
		
		return new Onward(book_id, quantity_purchased);
	}
}
