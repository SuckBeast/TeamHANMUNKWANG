package Model;

public class ProductVo {
	int pNum;
	String name;
	int price;
	int amount;
	
	public ProductVo(int pNum, String name, int price, int amount) {
		super();
		this.pNum = pNum;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getpNum() {
		return pNum;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}
	
	
	
	
	
}
