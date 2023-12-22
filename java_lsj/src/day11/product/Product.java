package day11.product;

/* 중복된 제품명 x
 * 
 */
public class Product {
	//제품 이름, 재고개수, 판매개수, 가격, 제품 한개의 총판매가격
	private String name;
	private int counts,s_count,price,totalprice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return counts;
	}
	public void setCount(int count) {
		this.counts = count;
	}
	public int getS_count() {
		return s_count;
	}
	public void setS_count(int s_count) {
		this.s_count = s_count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	/**
	 * 제품정보 보여주기
	 */
	public void printInfo() {
		System.out.print(name + " - ");
		System.out.print("재고개수 : " + counts + " ");
		System.out.print("판매가격 : " + price + "\n");
	}
	
	public void printSales() {
		System.out.println(""+name+"			"+s_count+"			"+totalprice);
	}
	
	public void update(int price) {
		this.price = price;
	}
	
	public boolean equals(String name) {
		return this.name.equals(name);
	}
	
	public Product(String name, int count, int price) {
		super();
		this.name = name;
		this.counts = count;
		this.price = price;
	}
}
