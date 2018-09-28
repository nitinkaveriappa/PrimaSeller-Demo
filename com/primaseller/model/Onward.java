package com.primaseller.model;


/**. 
* @author Nitin Kaveriappa
*/
public class Onward {
	private String book_id;
	private int quantity_purchased;
	
	public Onward(String book_id, int quantity_purchased) {
		this.book_id = book_id;
		this.quantity_purchased = quantity_purchased;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public int getQuantity_purchased() {
		return quantity_purchased;
	}
	public void setQuantity_purchased(int quantity_purchased) {
		this.quantity_purchased = quantity_purchased;
	}
	@Override
	public String toString() {
		return "Onward [book_id=" + book_id + ", quantity_purchased=" + quantity_purchased + "]";
	}
	
}
