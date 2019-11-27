package com.example.project311;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Button mBtnTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = (Button) findViewById(R.id.btn_login);
        mBtnTextView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,LoginPageActivity.class);
                startActivity(intent);
            }
        });

        /*
        mBtnTextView = (Button) findViewById(R.id.btn_register);
        mBtnTextView.setOnClickListener(new View.OnClickListener(){
            //跳转到注册界面
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
         */


    }
}
