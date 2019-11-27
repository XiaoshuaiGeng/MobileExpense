package com.example.project311;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginPageActivity extends AppCompatActivity {

    private Button mEditTextView;

    private Button mBtnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mBtnTextView = (Button) findViewById(R.id.ensureLogin);
        mBtnTextView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent(LoginPageActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });


    }
}
