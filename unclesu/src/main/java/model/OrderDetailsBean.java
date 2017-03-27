package model;

public class OrderDetailsBean {
	private int odd_id;
	private int odd_orderid;
	private int odd_mealid;
	private int ordd_count;
	private double odd_money;
	@Override
	public String toString() {
		return "odd_id=" + odd_id + ", odd_orderid=" + odd_orderid + ", odd_mealid=" + odd_mealid
				+ ", ordd_count=" + ordd_count + ", odd_money=" + odd_money ;
	}
	public int getOdd_id() {
		return odd_id;
	}
	public void setOdd_id(int odd_id) {
		this.odd_id = odd_id;
	}
	public int getOdd_orderid() {
		return odd_orderid;
	}
	public void setOdd_orderid(int odd_orderid) {
		this.odd_orderid = odd_orderid;
	}
	public int getOdd_mealid() {
		return odd_mealid;
	}
	public void setOdd_mealid(int odd_mealid) {
		this.odd_mealid = odd_mealid;
	}
	public int getOrdd_count() {
		return ordd_count;
	}
	public void setOrdd_count(int ordd_count) {
		this.ordd_count = ordd_count;
	}
	public double getOdd_money() {
		return odd_money;
	}
	public void setOdd_money(double odd_money) {
		this.odd_money = odd_money;
	}
	
	
}
