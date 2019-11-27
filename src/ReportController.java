import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReportController {

	/**
	 *
	 * @param start
	 * @param end
	 * @return A RecordList that all its records are filtered from startDate to endDate
	 */
	public RecordList filteredByDate(Date start, Date end) {
		//List<Record> records = new ArrayList<Record>();
		RecordList records = new RecordList();
		String sql = "select * from Record where Date >=? and Date <= ?";
		try (Connection c = DBUtil.getConn(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setDate(1, DateUtil.util2sql(start));
			ps.setDate(2, DateUtil.util2sql(end));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Record record = new Record();
				int RID = rs.getInt("RID");
				String Category = rs.getString("Category");
				double amount = rs.getInt("Amount");
				String Merchant_Name = rs.getString("Merchant_Name");
				Date date = rs.getDate("Date");

				record.setMerchant_Name(Merchant_Name);
				record.setCategory(Category);
				record.setAmount(amount);
				record.setMyDate(date);
				record.setId(RID);
				records.addRecord(record);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return records;
	}

	// TODO: 2019/11/27 Display recordlist of a month
//	public List<Record> listThisMonth() {
//		return list(DateUtil.getMonthBegin(), DateUtil.getMonthEnd());
//	}


	/**
	 * This method can be invoked from UserInterface to generate a Report
	 * that contains a RecordList filtered by startDate to endDate
	 * @param StartDate
	 * @param EndDate
	 * @return Report
	 */
	public Report InvokeGenerateReport(Date StartDate, Date EndDate) {// list the records from start date to end date
		return new Report(filteredByDate(StartDate, EndDate).getTotalAmount(),StartDate,EndDate);
	}
}
