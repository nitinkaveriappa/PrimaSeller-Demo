package com.primaseller.model;


/**. 
* @author Nitin Kaveriappa
*/
public class CliArgs {
	private String books_path;
	private String sales_path;
	private String top_selling_books;
	private String top_customers;
	private String sales_on_date;
	public String getBooks_path() {
		return books_path;
	}
	public void setBooks_path(String books_path) {
		this.books_path = books_path;
	}
	public String getSales_path() {
		return sales_path;
	}
	public void setSales_path(String sales_path) {
		this.sales_path = sales_path;
	}
	public String getTop_selling_books() {
		return top_selling_books;
	}
	public void setTop_selling_books(String top_selling_books) {
		this.top_selling_books = top_selling_books;
	}
	public String getTop_customers() {
		return top_customers;
	}
	public void setTop_customers(String top_customers) {
		this.top_customers = top_customers;
	}
	public String getSales_on_date() {
		return sales_on_date;
	}
	public void setSales_on_date(String sales_on_date) {
		this.sales_on_date = sales_on_date;
	}
	@Override
	public String toString() {
		return "CliArgs [books_path=" + books_path + ", sales_path=" + sales_path + ", top_selling_books="
				+ top_selling_books + ", top_customers=" + top_customers + ", sales_on_date=" + sales_on_date + "]";
	}

}
