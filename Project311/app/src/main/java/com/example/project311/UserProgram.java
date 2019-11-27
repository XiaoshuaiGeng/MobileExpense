package com.example.project311;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.project311.ReportController;

import java.util.Date;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class UserProgram {
	
	private int SelectionNum;
	
	private Date StartDate;		//report's attributes
	private Date EndDate;
	//private int TotalExpense;
	

	public void CreateOperation(int SelectionNum) {
		RecordController rc=new RecordController();
		switch(SelectionNum) {
		case 0:		//create record
			InputRecordInfo();

		//	rc.CreateANewRecord(myDate,Merchant_Name,Category,amount);
			break;
		case 1:
		//	rc.EraseRecord(SelectARecord());
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
	
	public void InputDateInterval() {
		//modify the local variable startdate & enddate
		
	}
	
	public void DisplayRecordList() {
		//retrieve whole list from database
		ReportController reportc=new ReportController();
		reportc.DisplayRecordList(reportc.list());		//reportc.list returns a list contains all records in DB
	}
	
	public void DisplayEmptyForm() {
		Record record = new Record();		//no attributes are initiated
		//record.DisplayInfoForm();
	}
	
	
	public static void main(String[] args) {
		UserProgram u  = new UserProgram();
		u.DisplayRecordList();
	}
}
