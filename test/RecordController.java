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

	public Record CreateANewRecord(int RID,Date myDate,String Merchant_Name,String Category,double amount) {
		Record record = new Record(RID,myDate,Merchant_Name,Category,amount);
		String sql = "insert into record values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConn(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setDouble(1, record.getAmount());
			ps.setString(2, record.getCategory());
			ps.setString(3, record.getMerchant_Name());
			ps.setDate(4, DateUtil.util2sql(record.getMyDate()));

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();		//id can be generated automatically ,no need to input id
			if (rs.next()) {
				int id = rs.getInt(1);
				record.setId(id);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return record;
	}


	/*
	*
	* Erase a selected record according to its index(id)
	* */

	public int EraseRecord(int id) {

		try (Connection c = DBUtil.getConn(); Statement s = c.createStatement();) {

			String sql = "delete from Record where RID = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;
	}

	
	public void UpdateRecord(Record record) {		//update the info of a record to DB

		String sql = "update record set Amount= ?, Category= ?, Merchant_Name =?, Date = ? where RID = ?";
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
	
	//need a EditRecord then
	
}
