package com.example.project311;



import java.util.Date;

public class Record {
	private Date myDate;
	private String Merchant_Name;
	private int id;
	private String Category;
	//private int Currency;
	private double amount;

	public Record() {

	}

	public Record(Record r){
		this.id = r.id;
		this.myDate = r.myDate;
		this.Merchant_Name = r.Merchant_Name;
		this.Category = r.Category;
		this.amount = r. amount;
	}

	public Record(int id, Date myDate,String Merchant_Name,String Category,double amount) {

		this.id = id;
		this.myDate=myDate;
		this.Merchant_Name=Merchant_Name;
		this.Category=Category;
		this.amount=amount;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMerchant_Name() {
		return Merchant_Name;
	}

	public void setMerchant_Name(String Merchant_Name) {
		this.Merchant_Name = Merchant_Name;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public String toString() {
		String result = ""+id+",";
		result += myDate+",";
		result += Merchant_Name+",";
		result += Category+",";
		//result += currency.toString()+",";
		result += amount+"\n";
		return result;
	}
}