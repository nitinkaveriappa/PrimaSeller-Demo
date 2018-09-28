package com.primaseller.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import com.primaseller.model.Book;
import com.primaseller.model.CliArgs;
import com.primaseller.model.Sale;
import com.primaseller.util.BookSalesUtil;
import com.primaseller.util.BooksUtil;
import com.primaseller.util.CliArgsUtil;
import com.primaseller.util.SalesUtil;

public class BookSales {
	public static void main(String args[]) {
		//Parses the Arguments passed in the CLI
		CliArgs cliArgs = CliArgsUtil.parseCliArgs(args);
//		System.out.println(cliArgs);
		
		List<Book> books = BooksUtil.readBooksFromCSV(cliArgs.getBooks_path());
//		for (Book b : books) { 
//			System.out.println(b); 
//		}
		List<Sale> sales = SalesUtil.readSalesFromCSV(cliArgs.getSales_path());
//		for(Sale s : sales) {
//			System.out.println(s);
//		}
		
		if(!cliArgs.getTop_selling_books().equals(null)) {
			List<String> list = BookSalesUtil.topSellingBooks(books,sales);
			System.out.print("top_selling_books\t");
			int n = Integer.parseInt(cliArgs.getTop_selling_books()) < list.size() ? Integer.parseInt(cliArgs.getTop_selling_books()) : list.size();
			for(int i = 0; i < n; i++) {
				System.out.print(list.get(i)+"\t");
			}
			System.out.println();
		}
		if(!cliArgs.getTop_customers().equals(null)) {
			List<String> list = BookSalesUtil.getTopCustomers(books,sales);
			System.out.print("top_customers\t");
			int n = Integer.parseInt(cliArgs.getTop_customers()) < list.size() ? Integer.parseInt(cliArgs.getTop_customers()) : list.size();
			for(int i = 0; i < n; i++) {
				System.out.print(list.get(i)+"\t");
			}
			System.out.println();
		}
		if(!cliArgs.getSales_on_date().equals(null)) {
			HashMap<String, Double> hm = BookSalesUtil.getSalesOnDate(books,sales);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String sales_on_date = null;
			try {
				sales_on_date = format.parse(cliArgs.getSales_on_date()).toString();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(hm.containsKey(sales_on_date)) {
				System.out.print("sales_on_date\t" + cliArgs.getSales_on_date() + "\t" + hm.get(sales_on_date));
			}
			else {
				System.out.print("sales_on_date\t" + cliArgs.getSales_on_date() + "\t" + "no sales on this date");
			}
			System.out.println();
		}
	}

}
