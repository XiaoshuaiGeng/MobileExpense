package comp311;

import java.util.Date;

public class Record {
	private Date myDate;
	private String Merchant_Name;
	private int id;
	private String Category;
	//private int Currency;	//是转化过的USD, 之前需要根据currency rate and input转换
	private double amount;
	
	public Record() {

	}
	
	public Record(Date myDate,String Merchant_Name,String Category,double amount) {
		
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

	public void DisplayInfoForm() {
		//display a empty record form 
	}
}