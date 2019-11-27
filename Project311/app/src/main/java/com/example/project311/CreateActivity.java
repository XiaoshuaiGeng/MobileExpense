package com.example.project311;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        //get info from textview

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


                Intent intent = new Intent(CreateActivity.this,HomepageActivity.class);
                startActivity(intent);
            }
        });

        class CreateData extends AsyncTask<String, String, String> {
            private int rid = -1;

            public CreateData(int rid)
            {
                this.rid = rid;
            }
            protected String doInBackground(String... params) {

                //  System.out.println("111111111111111111111111111");
                //   Global.recordc.EraseRecord(rid);
                //Global.recordc.CreateANewRecord();
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


    }
}
