package Model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import oracle.sql.DATE;

public class Cart {
	private int product_num;
	private String id;
	private int order_count;
	
	public Cart(int product_num, String id, int order_count) {
		super();
		this.product_num = product_num;
		this.id = id;
		this.order_count = order_count;
	}

	public int getProduct_num() {
		return product_num;
	}
	public String getId() {
		return id;
	}
	public int getOrder_count() {
		return order_count;
	}
	
	
}
