import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

class CurrencyController {

	public CurrencyController() {
		// TODO Auto-generated constructor stub	
	}
	public CurrencyList getCurrencyList(){
		
		CurrencyList records = new CurrencyList();
		String sql = "select * from Currency";
		try (Connection c = DBUtil.getConn(); PreparedStatement ps = c.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Currency currency = new Currency();
				//Retrieve the currency attributes from the database
				String currencyName = rs.getString("cName");
				double currency_to_USD = rs.getDouble("cc_to_USD");
				String currency_symbol = rs.getString("cSymbol"); 
				//set to local buffer
				currency.setCurrency_name(currencyName);
				currency.setCurrency_symbol(currency_symbol);
				currency.setCurrency_to_USD(currency_to_USD);
				records.addRecord(currency);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return records;
	}
}
