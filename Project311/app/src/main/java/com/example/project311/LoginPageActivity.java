package com.example.project311;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class LoginPageActivity extends AppCompatActivity {

    private Button mEditTextView;

    private Button mBtnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mBtnTextView = (Button) findViewById(R.id.ensureLogin);
      //  System.out.println("!!!!!!!!");
        mBtnTextView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                TextView nTV = (TextView) findViewById(R.id.Merchant1);
                TextView pwdTV = (TextView) findViewById(R.id.Merchant2);
                String name = nTV.getText().toString();
                String pwd = pwdTV.getText().toString();

                System.out.println("00000000000");
                ELogin elg = new ELogin(name, pwd);
                elg.execute();


            }
        });
    }

    class ELogin extends AsyncTask<String, String, String> {
        private String name;
        private String pwd;

        public ELogin(String name, String pwd)
        {
            this.name = name;
            this.pwd = pwd;
        }

        protected String doInBackground(String... params) {


            if(Global.loginc.VerifyUserID(name, pwd))
            {
                Intent intent = new Intent(LoginPageActivity.this, HomepageActivity.class);
                startActivity(intent);
            }

            return null;
        }

        protected void onPostExecute(String msg)
        {

        }
    }
}
