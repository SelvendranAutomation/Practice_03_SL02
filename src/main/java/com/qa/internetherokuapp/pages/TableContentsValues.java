package com.qa.internetherokuapp.pages;

public class TableContentsValues {
	
	
	private String company;
	private String group;
	private float prevClose;
	private float currentPrice;
	private float change;
	
	
	
	public TableContentsValues(String company, String group, float prevClose, float currentPrice, float change) {
		this.company = company;
		this.group = group;
		this.prevClose = prevClose;
		this.currentPrice = currentPrice;
		this.change = change;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public float getPrevClose() {
		return prevClose;
	}
	public void setPrevClose(float prevClose) {
		this.prevClose = prevClose;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public float getChange() {
		return change;
	}
	public void setChange(float change) {
		this.change = change;
	}

	
	
}
