package com.primaseller.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.primaseller.model.Book;

public class BooksUtil {
	/** 
	    * This method parses the books.list csv file. 
	    * @param filename The path\filname of Books CSV. 
	    * @return books List of Books . 
	 */
	public static List<Book> readBooksFromCSV(String fileName) { 
		List<Book> books = new ArrayList<>(); 
		Path pathToFile = Paths.get(fileName); 
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
			String line = br.readLine(); 
			while (line != null) { 
				String[] attributes = line.split(","); 
				Book book = createBook(attributes); 
				books.add(book); 
				line = br.readLine();
			} 
		} catch (IOException ioe) { 
			ioe.printStackTrace(); 
			} 
		return books; 
	} 
	/** 
	    * This method creates new Book objects from the csv data . 
	    * @param metadata String array of single row in the csv file. 
	    * @return Book Book object created. 
	 */
	private static Book createBook(String[] metadata) { 
		String book_id = metadata[0];
		String book_title = metadata[1];
		String book_author = metadata[2];
		double book_price = Double.parseDouble(metadata[3]);
		
		return new Book(book_id, book_title, book_author, book_price); 
	} 
}
