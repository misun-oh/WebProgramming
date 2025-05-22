package com.object.practice;

/*
 * 필드의 정보와 setter, getter메서드로만 이루어진 클래스를
 * DTO, VO 라고 합니다.
 * 
 * 데이터를 옮기는 상자같은 역할을 합니다
 */
public class Product {
	
	private String id;		// 상품 아이디
	private String name;
	private String site;
	private String product;
	private int price;
	private double tax;
	
	public Product() {
	}
	
	public Product(String id, String name, String site
					, String product, int price, double tax) {
		
		this.id = id;
		this.name = name;
		this.site = site;
		this.product = product;
		this.price = price;
		this.tax = tax;
	}
	
	public String information() {
		String msg = "id : " + id + ", name : " + name + ", site : " + site
					+", product : " + product + ", price : " + price +", tax : " + tax;
		return msg;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getTax() {
		return tax;
	}
	public int getTaxPrice() {
		return price+(int)(price*tax);
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
}
