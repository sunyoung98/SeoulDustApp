package com.superdroid.test.seouldust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DateActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        Intent intent=getIntent();
        String url = intent.getExtras().getString("uri");
        t1=(TextView)findViewById(R.id.data1);
        t2=(TextView)findViewById(R.id.data2);
        t3=(TextView)findViewById(R.id.data3);
        t4=(TextView)findViewById(R.id.data4);
        t5=(TextView)findViewById(R.id.data5);
        t6=(TextView)findViewById(R.id.data6);
        error=(TextView)findViewById(R.id.errorCheck);
        MyAsyncTask task = new MyAsyncTask(t1,t2,t3,t4,t5,t6,url,error);
        task.execute();
    }
}
