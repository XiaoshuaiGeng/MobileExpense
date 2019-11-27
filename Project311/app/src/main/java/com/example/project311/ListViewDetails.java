package com.example.project311;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class ListViewDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_details);
       // System.out.println("!!!!!!!!!!!!"+Global.records.recordList.toString());

        TextView mTv = (TextView) findViewById(R.id.Merchant2);
        TextView categTv = (TextView) findViewById(R.id.Catagory);
        TextView amountTv = (TextView) findViewById(R.id.Amount);
        TextView dateTv = (TextView) findViewById(R.id.Date);

        int index = getIntent().getIntExtra("com.example.project311.INDEX", -1);

        Record recd = Global.records.recordList.get(index);

        String name = recd.getCategory();
        String cost =  recd.getAmount()+"";
        String date = recd.getMyDate().toString();
        String mName = recd.getMerchant_Name();
      //  TextView mtv = (TextView) v.findViewById(R.id.M_NameTextView);

        categTv.setText(name);
        amountTv.setText(cost);
        mTv.setText(mName);
        dateTv.setText(date);


        Button eraseBtn = (Button) findViewById(R.id.cleanUp);
        eraseBtn.setOnClickListener(new View.OnClickListener() {

            int index = getIntent().getIntExtra("com.example.project311.INDEX", -1);
            @Override
            public void onClick(View v) {
                int rid = Global.records.recordList.get(index).getId();
           //     System.out.println("\n\n\nindex: "+index+" RID: "+rid +  "****************************" + Global.records.toString()+"\n\n\n");
                Global.records.removeRecord(rid);
            //    System.out.println("\n\n\n"+rid +  "!!!!!!!!!!!!delete!!!!!" + Global.records.toString()+"\n\n\n");
               // System.out.println(rid +  "!!!!!!!!!!!!delete!!!!!" + Global.records.toString());
            Intent intent1 = new Intent(ListViewDetails.this, DataBaseActivity.class);
              //  Global.records.removeRecord(rid);
            startActivity(intent1);
            EraseData ed = new EraseData(rid);
            ed.execute();

            }
        });

        Button cancelBtn = (Button) findViewById(R.id.Cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(ListViewDetails.this, DataBaseActivity.class);
                startActivity(intent1);
            }
        });

        Button saveBtn = (Button) findViewById(R.id.Save);
        saveBtn.setOnClickListener(new View.OnClickListener() {

            int index = getIntent().getIntExtra("com.example.project311.INDEX", -1);
            @Override
            public void onClick(View v) {
                int rid = Global.records.recordList.get(index).getId();
                TextView mTv = (TextView) findViewById(R.id.Merchant2);
                TextView categTv = (TextView) findViewById(R.id.Catagory);
                TextView amountTv = (TextView) findViewById(R.id.Amount);
                TextView dateTv = (TextView) findViewById(R.id.Date);



                Record temp = Global.records.getRecord(rid);


                temp.setMerchant_Name(mTv.getText().toString());
                temp.setCategory(categTv.getText().toString());
                temp.setAmount(Double.parseDouble(amountTv.getText().toString()));
                try {
//                    Calendar c = Calendar.getInstance();
//                    c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateTv.getText().toString()));
//
//                    temp.setMyDate(c.getTime()) ;
                    temp.setMyDate(new SimpleDateFormat("yyyy-MM-dd").parse(dateTv.getText().toString())) ;
                }catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println(temp.toString());

           //     System.out.println("\n\n\nindex: "+index+" RID: "+rid +  "****************************" + Global.records.toString()+"\n\n\n");
                //    System.out.println("\n\n\n"+rid +  "!!!!!!!!!!!!delete!!!!!" + Global.records.toString()+"\n\n\n");
                // System.out.println(rid +  "!!!!!!!!!!!!delete!!!!!" + Global.records.toString());
                Intent intent1 = new Intent(ListViewDetails.this, DataBaseActivity.class);
                //  Global.records.removeRecord(rid);
                startActivity(intent1);
                SaveData sd = new SaveData(temp);
                sd.execute();

            }
        });

    }


    class EraseData extends AsyncTask<String, String, String> {
        private int rid = -1;

        public EraseData(int rid)
        {
            this.rid = rid;
        }
        protected String doInBackground(String... params) {

          //  System.out.println("111111111111111111111111111");
            //   Global.recordc.EraseRecord(rid);
            Global.recordc.EraseRecord(rid);
         //   System.out.println("222222222222222222222222222");
            return null;
        }

        protected void onPostExecute(String msg)
        {
            /*
            if (!Global.records.isEmpty()) {
                Global.recordc.EraseRecord(Integer.parseInt(msg));
            }
             */
        }
    }

    class SaveData extends AsyncTask<String, String, String> {
        private Record record;


        public SaveData(Record r)
        {
            this.record = r;
        }

        protected String doInBackground(String... params) {

            Global.recordc.UpdateRecord(record);
            return null;
        }

        protected void onPostExecute(String msg)
        {
        }
    }
}
