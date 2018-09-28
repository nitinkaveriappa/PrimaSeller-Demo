package com.primaseller.model;

import java.util.Date;
import java.util.List;

/**. 
* @author Nitin Kaveriappa
*/
public class Sale {
	private Date sale_date;
	private String sale_email;
	private String sale_payment_method;
	private int sale_item_count;
	private List<Onward> onwards;
	
	public Sale(Date sale_date, String sale_email, String sale_payment_method, int sale_item_count,
			List<Onward> onwards) {
		this.sale_date = sale_date;
		this.sale_email = sale_email;
		this.sale_payment_method = sale_payment_method;
		this.sale_item_count = sale_item_count;
		this.onwards = onwards;
	}
	public Date getSale_date() {
		return sale_date;
	}
	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}
	public String getSale_email() {
		return sale_email;
	}
	public void setSale_email(String sale_email) {
		this.sale_email = sale_email;
	}
	public String getSale_payment_method() {
		return sale_payment_method;
	}
	public void setSale_payment_method(String sale_payment_method) {
		this.sale_payment_method = sale_payment_method;
	}
	public int getSale_item_count() {
		return sale_item_count;
	}
	public void setSale_item_count(int sale_item_count) {
		this.sale_item_count = sale_item_count;
	}
	public List<Onward> getOnwards() {
		return onwards;
	}
	public void setOnwards(List<Onward> onwards) {
		this.onwards = onwards;
	}
	@Override
	public String toString() {
		return "Sale [sale_date=" + sale_date + ", sale_email=" + sale_email + ", sale_payment_method="
				+ sale_payment_method + ", sale_item_count=" + sale_item_count + ", onwards=" + onwards + "]";
	}

}
