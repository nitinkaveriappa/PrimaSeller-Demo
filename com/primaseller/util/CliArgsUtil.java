package com.primaseller.util;

import com.primaseller.model.CliArgs;

public class CliArgsUtil {

	/** 
	    * This method parses the arguments passed in the CLI. 
	    * @param args The String arrary of CLI arguments. 
	 */
	public static CliArgs parseCliArgs(String[] args) {
		CliArgs cliArgs = new CliArgs();
		String books_path = null;
		String sales_path = null;
		String top_selling_books = null;
		String top_customers = null;
		String sales_on_date = null;
		for(int i = 0; i<args.length; i++) {
			if(args[i].toLowerCase().indexOf("--books=") != -1) {
				books_path = args[i].split("=")[1];
			}
			if(args[i].toLowerCase().indexOf("--sales=") != -1) {
				sales_path = args[i].split("=")[1];
			}
			if(args[i].toLowerCase().indexOf("--top_selling_books=") != -1) {
				top_selling_books = args[i].split("=")[1];
			}
			if(args[i].toLowerCase().indexOf("--top_customers=") != -1) {
				top_customers = args[i].split("=")[1];
			}
			if(args[i].toLowerCase().indexOf("--sales_on_date=") != -1) {
				sales_on_date = args[i].split("=")[1];
			}
		}
		cliArgs.setBooks_path(books_path);
		cliArgs.setSales_path(sales_path);
		cliArgs.setTop_selling_books(top_selling_books);
		cliArgs.setTop_customers(top_customers);
		cliArgs.setSales_on_date(sales_on_date);
		return cliArgs;
	}

}
