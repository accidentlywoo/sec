package com.my.vo;

public class Product {
	private String prod_no;
	private String prod_name;
	private String prof_price;
	
	
	public Product() {}
	public Product(String prod_no, String prod_name, String prof_price) {
		this.prod_no = prod_no;
		this.prod_name = prod_name;
		this.prof_price = prof_price;
	}
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProf_price() {
		return prof_price;
	}
	public void setProf_price(String prof_price) {
		this.prof_price = prof_price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prod_no == null) ? 0 : prod_no.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (prod_no == null) {
			if (other.prod_no != null)
				return false;
		} else if (!prod_no.equals(other.prod_no))
			return false;
		return true;
	}
	
}
