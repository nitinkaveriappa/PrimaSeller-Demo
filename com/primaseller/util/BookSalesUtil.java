package com.primaseller.util;

import java.util.*;

import com.primaseller.model.Book;
import com.primaseller.model.Onward;
import com.primaseller.model.Sale;

public class BookSalesUtil {
	/** 
	    * This method computes the topSellingBook. 
	    * @param books List of Books
	    * @param sales List of Sales 
	    * @return list List of topSellingBooks ids in decending order 
	    */
	public static List<String> topSellingBooks(List<Book> books, List<Sale> sales) {
		HashMap<String, Double> pricemap = new HashMap<>();
		for(Book book: books) {
			pricemap.put(book.getBook_id(), book.getBook_price());
		}
		
		HashMap<String, Double> hm = new HashMap<>();
		for(Sale sale : sales) {
			for(Onward onward : sale.getOnwards()) {
				if(hm.containsKey(onward.getBook_id())) {
					hm.put(onward.getBook_id(), hm.get(onward.getBook_id()) + (pricemap.get(onward.getBook_id())*onward.getQuantity_purchased()));
				}
				else {
					hm.put(onward.getBook_id(), (pricemap.get(onward.getBook_id())*onward.getQuantity_purchased()));
				}
			}
		}
//		System.out.println("topSellingBooks: "+hm);
		List<String> list = new ArrayList<>(sortHashMapByPrice(hm).keySet());
		return list;
	}
	
	/** 
	    * This method computes the getTopCustomers. 
	    * @param books List of Books
	    * @param sales List of Sales 
	    * @return list List of TopCustomers email ids in decending order 
	    */
	public static List<String> getTopCustomers(List<Book> books, List<Sale> sales) {
		HashMap<String, Double> pricemap = new HashMap<>();
		for(Book book: books) {
			pricemap.put(book.getBook_id(), book.getBook_price());
		}
		
		HashMap<String, Double> hm = new HashMap<>();
		for(Sale sale : sales) {
			for(Onward onward : sale.getOnwards()) {
				if(hm.containsKey(sale.getSale_email())) {
					hm.put(sale.getSale_email(), hm.get(sale.getSale_email()) + (pricemap.get(onward.getBook_id())*onward.getQuantity_purchased()));
				}
				else {
					hm.put(sale.getSale_email(), (pricemap.get(onward.getBook_id())*onward.getQuantity_purchased()));
				}
			}
		}
//		System.out.println("getTopCustomers: "+hm);
		List<String> list = new ArrayList<>(sortHashMapByPrice(hm).keySet());
		return list;
	}

	/** 
	    * This method computes the getTopCustomers. 
	    * @param books List of Books
	    * @param sales List of Sales 
	    * @return HashMap HashMap of <Sale_Date, Total_Price_of_Books_Sold> in decending order of price
	    */
	public static HashMap<String,Double> getSalesOnDate(List<Book> books, List<Sale> sales) {
		HashMap<String, Double> pricemap = new HashMap<>();
		for(Book book: books) {
			pricemap.put(book.getBook_id(), book.getBook_price());
		}
		
		HashMap<String, Double> hm = new HashMap<>();
		for(Sale sale : sales) {
			for(Onward onward : sale.getOnwards()) {
				if(hm.containsKey(sale.getSale_date().toString())) {
					hm.put(sale.getSale_date().toString(), hm.get(sale.getSale_date().toString()) + (pricemap.get(onward.getBook_id())*onward.getQuantity_purchased()));
				}
				else {
					hm.put(sale.getSale_date().toString(), (pricemap.get(onward.getBook_id())*onward.getQuantity_purchased()));
				}
			}
		}
//		System.out.println("getSalesOnDate: "+hm);
		return sortHashMapByPrice(hm);
		
	}
	
	/** 
	    * This method sorts the HashMap in Decending Order of values. 
	    * @param hm HashMap<String, Double> to be sorted
	    * @return temp Sorted HashMap<String, Double> in decending order of values 
	    */
	private static HashMap<String, Double> sortHashMapByPrice(HashMap<String, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > list = new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort(new Comparator<Map.Entry<String, Double> >() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Double> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}
