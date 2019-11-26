

import java.util.Date;

public class Report {
	private Date StartDate;		//report's attributes
	private Date EndDate;
	private int TotalExpense;
	private String ReportTitle;	//澶ф鏄姤鍛婂垱寤烘棩鏈�
	
	public Report(int TotalExpense,Date StartDate,Date EndDate) {
		this.TotalExpense=TotalExpense;
		this.StartDate=StartDate;
		this.EndDate=EndDate;
	}
	
	public void DisplayReport() {
		// format the report including reportTitle
	}
}
