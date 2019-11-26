package comp311;

import java.util.Date;

public class Report {
	private Date StartDate;		//report's attributes
	private Date EndDate;
	private int TotalExpense;
	private String ReportTitle;	//大概是报告创建日期
	
	public Report(int TotalExpense,Date StartDate,Date EndDate) {
		this.TotalExpense=TotalExpense;
		this.StartDate=StartDate;
		this.EndDate=EndDate;
	}
	
	public void DisplayReport() {
		// format the report including reportTitle
	}
}
