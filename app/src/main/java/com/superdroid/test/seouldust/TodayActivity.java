package com.superdroid.test.seouldust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TodayActivity extends AppCompatActivity {

    TextView t1, t2,error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        Intent intent=getIntent();
        String url = intent.getExtras().getString("uri");
        t1=(TextView)findViewById(R.id.data1);
        t2=(TextView)findViewById(R.id.data2);
        error=(TextView)findViewById(R.id.errorCheck);
        MyAsyncTask2 task2= new MyAsyncTask2(t1,t2,url,error);
        task2.execute();
    }
}
