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

        String name = Global.records.recordList.get(index).getCategory();
        String cost = "$" + Global.records.recordList.get(index).getAmount();
        String date = Global.records.recordList.get(index).getMyDate().toString();
        String mName = Global.records.recordList.get(index).getMerchant_Name();
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
                System.out.println("\n\n\nindex: "+index+" RID: "+rid +  "****************************" + Global.records.toString()+"\n\n\n");
                Global.records.removeRecord(rid);
            //    System.out.println("\n\n\n"+rid +  "!!!!!!!!!!!!delete!!!!!" + Global.records.toString()+"\n\n\n");
               // System.out.println(rid +  "!!!!!!!!!!!!delete!!!!!" + Global.records.toString());
            Intent intent1 = new Intent(ListViewDetails.this, DataBaseActivity.class);
              //  Global.records.removeRecord(rid);
            startActivity(intent1);
            EraseData ed = new EraseData();
            ed.execute(String.valueOf(rid));

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
    }


    class EraseData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {

            //   Global.recordc.EraseRecord(rid);

            return null;
        }

        protected void onPostExecute(String msg)
        {
            if (!Global.records.isEmpty()) {
                Global.recordc.EraseRecord(Integer.parseInt(msg));
            }
        }
    }
}
