import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordController {
	
	public RecordController() {
		
	}

	/*
	public boolean IsSelectionValid(int SelectionNum) {
		if (SelectionNum>2 || SelectionNum<0){
			return false;
		}
		return true;
	}
	*/

	public Record CreateANewRecord(Date myDate,String Merchant_Name,String Category,double amount) {
		//String sql = "insert into record values(null,?,?,?,?)";
		String sql = "INSERT INTO `Record` (`RID`, `Merchant_Name`, `Date`, `Category`, `Amount`) VALUES (null,?,?,?,?)";
		try (Connection c = DBUtil.getConn(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, Merchant_Name);
			ps.setDate(2, DateUtil.util2sql(myDate));
			ps.setString(3, Category);
			ps.setDouble(4, amount);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();		//id can be generated automatically ,no need to input id
			if (rs.next()) {
				return new Record(rs.getInt(1),myDate,Merchant_Name,Category,amount);
			}


		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}


	/*
	*
	* Erase a selected record according to its index(id)
	* */

	public int EraseRecord(int id) {
        String sql = "DELETE FROM Record WHERE RID =?";
		try (Connection c = DBUtil.getConn(); PreparedStatement ps =  c.prepareStatement(sql);) {
            ps.setInt(1,id);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	//update the info of a record to DB
	public void UpdateRecord(Record record) {

		String sql = "update Record set Amount= ?, Category= ?, Merchant_Name =?, Date = ? where RID = ?";
		try (Connection c = DBUtil.getConn(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setDouble(1, record.getAmount());
			ps.setString(2, record.getCategory());
			ps.setString(3, record.getMerchant_Name());
			ps.setDate(4, DateUtil.util2sql(record.getMyDate()));
			ps.setInt(5, record.getId());

			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public RecordList getRecordList(){
		RecordList records = new RecordList();
		String sql = "select * from Record";
		try (Connection c = DBUtil.getConn(); PreparedStatement ps = c.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Record record = new Record();
				int id = rs.getInt("RID");
				String Category = rs.getString("Category");
				double amount = rs.getDouble("Amount");

				String Merchant_Name = rs.getString("Merchant_Name");
				Date date = rs.getDate("Date");

				record.setMerchant_Name(Merchant_Name);
				record.setCategory(Category);
				record.setAmount(amount);
				record.setMyDate(date);
				record.setId(id);
				records.addRecord(record);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return records;
	}
}
