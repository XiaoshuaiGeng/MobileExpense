package com.example.project311;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class HomepageActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnEditView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        mBtnTextView = (Button) findViewById(R.id.Logout);
        mBtnTextView.setOnClickListener(new View.OnClickListener(){
            //goto registar
            public void onClick(View v){
                Global.loginc.setAccess(false);
                Intent intent = new Intent(HomepageActivity.this, LoginPageActivity.class);
                startActivity(intent);

            }
        });

        mBtnEditView = (Button) findViewById(R.id.Create);
        mBtnEditView.setOnClickListener(new View.OnClickListener(){
            //goto login
            public void onClick(View v){
                Intent intent = new Intent(HomepageActivity.this,CreateActivity.class);
                startActivity(intent);
            }
        });

        Button recordList = (Button) findViewById(R.id.RecordList);
        recordList.setOnClickListener(new View.OnClickListener(){
            //goto login
            public void onClick(View v){
                Intent intent = new Intent(HomepageActivity.this, DataBaseActivity.class);
                startActivity(intent);
            }
        });



    }
}
