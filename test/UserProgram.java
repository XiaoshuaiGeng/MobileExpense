

import java.util.Calendar;
import java.util.Date;


public class UserProgram {

	private RecordController recordc = new RecordController();
	private ReportController reportc = new ReportController();
	private RecordList list = new RecordList();
	private int SelectionNum;
	
	private Date StartDate;		//report's attributes
	private Date EndDate;
	//private int TotalExpense;
	/*
	public void CreateOperation(int SelectionNum) {
		RecordController rc=new RecordController();
		switch(SelectionNum) {
		case 0:		//create record
			InputRecordInfo();

			rc.CreateANewRecord(myDate,Merchant_Name,Category,amount);
			break;
		case 1:
			rc.EraseRecord(SelectARecord());
			break;
		case 2:

			//rc3.EditRecord(SelectARecord());		//undefined so far
			break;
		case 3:		//generate and display report
			InputDateInterval();
			ReportController reportc=new ReportController();
			reportc.InvokeGenerateReport(StartDate, EndDate).DisplayReport();
			break;
		}
		
	}
	
	public void InputRecordInfo() {
		//杈撳叆鍒涘缓record鏃剁殑璁板綍淇℃伅
	}
	
	/*public int SelectARecord() {
		//杩斿洖閫変腑鐨剅ecord鐨刬d
	}*/

//
//	public void InputDateInterval() {
//		//modify the local variable startdate & enddate
//
//	}
//
	/*
	* Return a string constains a list of record info
	* */
	public String DisplayRecordList() {
		//retrieve whole list from database
		//ReportController reportc=new ReportController();
		//reportc.DisplayRecordList(reportc.list());		//reportc.list returns a list contains all records in DB

		return recordc.getRecordList().toString();
	}
	
	public void DisplayEmptyForm() {
		Record record = new Record();		//no attributes are initiated
		record.toString();
	}
	
	//Tester Program
	public static void main(String[] args) {
		UserProgram u  = new UserProgram();
		System.out.println(u.DisplayRecordList());
		Calendar c = Calendar.getInstance();
		c.set(2019,Calendar.APRIL,4);
		Date temp = c.getTime();
		u.list.addRecord(u.recordc.CreateANewRecord(temp ,"computer","Electronics",1999.99));
		System.out.println(u.DisplayRecordList());
	}
}
