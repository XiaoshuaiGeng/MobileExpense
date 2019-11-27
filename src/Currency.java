
public class Currency {
    private double Currency_to_USD;
    /* Since the international currency exchange rates depend on USD,
    set the base exchange rate to USD as the standard rate.*/
    private String Currency_name;
    private char Currency_symbol;

    /** default constructor */
    public Currency() {
        System.out.println("Default constructor of class Currency");
    }

    public Currency(String Currency_name,char Currency_symbol) {

        this.Currency_name=Currency_name;
        this.Currency_symbol=Currency_symbol;

    }

    public String getCurrency_name() {
        return Currency_name;
    }

    public void setCurrency_name(String Currency_name) {
        this.Currency_name = Currency_name;
    }

    public char getCurrency_symbol() {
        return Currency_symbol;
    }

    public void setCurrency_symbol(char Currency_symbol) {
        this.Currency_symbol = Currency_symbol;
    }

    public void DisplayInfoForm() {
        //display a empty Currency form
    }
}
