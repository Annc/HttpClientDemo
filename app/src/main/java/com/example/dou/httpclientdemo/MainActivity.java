package com.example.dou.httpclientdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private Button mButton_1;
    private Button mButton_2;
    private String mAddress ="http://cloud.bmob.cn/0906a62b462a3082/";
    private String method = "getMemberBySex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton_1 = (Button)findViewById(R.id.btn_1);
        mButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGet("boy");

            }
        });

        mButton_2 = (Button)findViewById(R.id.btn_2);
        mButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPost("boy");
            }
        });


    }

    private void doGet(String s) {
        final String getUrl = mAddress + method + "?sex=" + s;
        HttpGet httpGet = new HttpGet(getUrl);
        try {
            new DefaultHttpClient().execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void doPost(String s) {
    }
}
