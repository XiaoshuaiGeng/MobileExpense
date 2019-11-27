
public class Currency {

	private double Currency_to_USD;
	/* Since the international currency exchange rates depend on USD,
	set the base exchange rate to USD as the standard rate.*/
	private String Currency_name;
	private String Currency_symbol;

	/** default constructor */
	public Currency() {
		System.out.println("Default constructor of class Currency");
	}
	public Currency(Currency r){
		this.Currency_name= r.Currency_name;
		this.Currency_symbol= r.Currency_symbol;
		this.Currency_to_USD = r.Currency_to_USD;
	}
	
	public Currency(String Currency_name,String Currency_symbol,double Currency_to_USD) {

		this.Currency_name=Currency_name;
		this.Currency_symbol=Currency_symbol;
		this.Currency_to_USD = Currency_to_USD;

	}

	public String getCurrency_name() {
		return Currency_name;
	}

	public void setCurrency_name(String Currency_name) {
		this.Currency_name = Currency_name;
	}

	public String getCurrency_symbol() {
		return Currency_symbol;
	}

	public void setCurrency_symbol(String Currency_symbol) {
		this.Currency_symbol = Currency_symbol;
	}

	public double getCurrency_to_USD() {
		return Currency_to_USD;
	}

	public void setCurrency_to_USD(double currency_to_USD) {
		Currency_to_USD = currency_to_USD;
	}

	public String toString() {
		return Currency_name+":"+Currency_symbol;
	}
}
