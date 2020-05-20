package com.my.vo;

import java.time.LocalDate;

public class Product {
	private long no; // 상품 번호
	private String name; // 상품명
	private long stock; // 재고
	private long price; // 가격
	private LocalDate stockDate; // 입고일자
	private LocalDate selftLife; // 유통기한
	private boolean isSale; // 판매여부
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public LocalDate getStockDate() {
		return stockDate;
	}
	public void setStockDate(LocalDate stockDate) {
		this.stockDate = stockDate;
	}
	public LocalDate getSelftLife() {
		return selftLife;
	}
	public void setSelftLife(LocalDate selftLife) {
		this.selftLife = selftLife;
	}
	public boolean isSale() {
		return isSale;
	}
	public void setSale(boolean isSale) {
		this.isSale = isSale;
	}
}
