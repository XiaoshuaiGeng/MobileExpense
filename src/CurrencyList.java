import java.util.ArrayList;

public class CurrencyList {
    private ArrayList<Currency> currencyList;

    public CurrencyList(){
        currencyList = new ArrayList<>();
    }

    public boolean addRecord(Currency record){
        return currencyList.add(record);
    }

    public Currency getCurrency(String Cname){//Cname= currency name selected by use from the drop down list
        for (Currency currency : currencyList) {
            if(currency.getCurrency_name().equals(Cname)){
                return currency;
            }
        }
        return null;
    }
}
