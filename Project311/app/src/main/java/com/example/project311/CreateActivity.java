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
import java.util.Date;
@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class CreateActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnSave;
    public Record red = new Record();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);






        mBtnTextView = (Button) findViewById(R.id.Cancel);
        mBtnTextView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(CreateActivity.this,HomepageActivity.class);
                startActivity(intent);
            }
        });

        mBtnTextView = (Button) findViewById(R.id.Save);
        mBtnTextView.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v){

                //get info from textview
                TextView mTv = (TextView) findViewById(R.id.Merchant2);
                TextView categTv = (TextView) findViewById(R.id.Catagory);
                TextView amountTv = (TextView) findViewById(R.id.Amount);
                TextView dateTv = (TextView) findViewById(R.id.Date);

                red.setMerchant_Name(mTv.getText().toString());
                red.setCategory(categTv.getText().toString());
                red.setAmount(Integer.parseInt(amountTv.getText().toString()));
                try {
                    red.setMyDate(new SimpleDateFormat("yyyy-MM-dd").parse(dateTv.getText().toString())) ;
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("00000000000000000000000000");
                CreateData ed = new CreateData(red);
                ed.execute();
                Intent intent = new Intent(CreateActivity.this,HomepageActivity.class);
                startActivity(intent);
            }
        });
    }

    class CreateData extends AsyncTask<String, String, String> {
        private Date myDate;
        private String Merchant_Name;
        private String Category;
        //private int Currency;
        private double amount;

        public CreateData(Record r){
            this.myDate = r.getMyDate();
            this.Merchant_Name = r.getMerchant_Name();
            this.Category = r.getCategory();
            this.amount = r.getAmount();
        }

        protected String doInBackground(String... params) {
            //  System.out.println("111111111111111111111111111");
            Global.recordc.CreateANewRecord(myDate,Merchant_Name,Category,amount);
           //    System.out.println("222222222222222222222222222");
            return null;
        }

        protected void onPostExecute(String msg)
        {
        }
    }
}
