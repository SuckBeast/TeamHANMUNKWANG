package Model;

public class Order {
	private String id;
	private int product_num;
	private int order_count;
	private String order_date;
	
	public Order(String id, int product_num, int order_count, String order_date) {
		super();
		this.id = id;
		this.product_num = product_num;
		this.order_count = order_count;
		this.order_date = order_date;
	}
	public String getId() {
		return id;
	}
	public int getProduct_num() {
		return product_num;
	}
	public int getOrder_count() {
		return order_count;
	}
	public String getOrder_date() {
		return order_date;
	}
	
	

}
