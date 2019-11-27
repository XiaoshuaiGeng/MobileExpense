package com.example.project311;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class MainActivity extends AppCompatActivity {

    ItemAdapter itemAdapter;
    Context thisContext;
    ListView myListView;
    TextView progressTextView;

    public RecordList records =  new RecordList();
   // Map<String, Double>fruitsMap = new LinkedHashMap<String, Double>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        progressTextView = (TextView)findViewById(R.id.progressTextView);
        thisContext = this;

        progressTextView.setText("");

        Button btn = (Button) findViewById(R.id.getDataBtn);
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                GetData getData = new GetData();
                getData.execute("");
            }
        });
    }

    class GetData extends AsyncTask<String, String, String> {

        String msg = "";
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        /*
        static final String DB_URL = "jdbc:mysql://" +
                DbStrings.DATABASE_URL + "/" +
                DbStrings.DATABASE_NAME;
        */

        String url = String.format("jdbc:mysql://%s:%d/%s?%s", DbStrings.ip, DbStrings.port, DbStrings.database, DbStrings.encoding);

        protected void onPreExecute() {
            progressTextView.setText("Connecting to database>>>");
        }

        @Override
        protected String doInBackground(String... params) {
            Connection conn = null;
            Statement stmt = null;
            RecordController recordc = new RecordController();
            records = recordc.getRecordList();

            /*
            try {

                String sql = "SELECT * FROM Record";
                conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql);

                Class.forName(JDBC_DRIVER);
                //       msg = "after class forname , connecting to database...";
                conn = DriverManager.getConnection(url, DbStrings.loginName, DbStrings.password);
                //      msg = "database connected...";
                //  System.out.println("!!!!!!!!!!!");

                stmt = conn.createStatement();
                String sql = "SELECT * FROM Record";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Record record_i = new Record();
                    String name = rs.getString("Category");
                    double price = rs.getDouble("Amount");
                    int id = rs.getInt("RID");
                    String Merchant_Name = rs.getString("Merchant_Name");
                    Date date = rs.getDate("Date");

                    record_i.setCategory(name);
                    record_i.setAmount(price);
                    record_i.setId(id);
                    record_i.setMerchant_Name(Merchant_Name);
                    record_i.setMyDate(date);
                    records.add(record_i);
                }

                msg = "Process complete...";
                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException connError) {
                msg = "An exception from JDBC";
                connError.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                msg = "class not found";
                e.printStackTrace();
            }

                 */
            return null;
        }

        protected void onPostExecute(String msg)
        {
            progressTextView.setText(this.msg);

    //        System.out.println( fruitsMap.size()+"############");
            if(!records.isEmpty())
            {
                itemAdapter = new ItemAdapter(thisContext,records.recordList);
                myListView.setAdapter(itemAdapter);
            }
        }
    }

    // ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
    // myListView.setAdapter(itemAdapter);
}

