

import java.util.Date;

public class Report {
	private Date StartDate;		//report's attributes
	private Date EndDate;		
	private double TotalExpense;
	private String ReportTitle;	
	private RecordList records;


	public Report(double TotalExpense,Date StartDate,Date EndDate) {
		this.TotalExpense=TotalExpense;
		this.StartDate=StartDate;
		this.EndDate=EndDate;
		records = new RecordList();
	}

    /**
     *
     * @return Return a RecordList that contains a list of Records between StartDate and EndDate
     */
	public RecordList getRecordList() {
		return records;
	}
}
