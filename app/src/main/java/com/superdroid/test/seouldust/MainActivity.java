package com.superdroid.test.seouldust;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    private String url="http://openapi.seoul.go.kr:8088/";
    private String serviceKey ="464366467162796937307557467578";
    private String nexturl="/xml/DailyAverageAirQuality/1/5/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        1);
            }
        }


    }
    public void OnClick(View v){
        int btnId= v.getId();
        TextView date= (TextView) findViewById(R.id.dateEditText);
        TextView region=(TextView) findViewById(R.id.regionEditText);
        TextView todayregion=(TextView) findViewById(R.id.todayRegionEditText);
        if(btnId==R.id.dateBtn){
            String datetext=date.getText().toString();
            String regiontext=region.getText().toString();
            if(regiontext!="" && datetext!="") {
                String inputSource = url + serviceKey + nexturl + datetext + "/" + regiontext;
                Intent intent = new Intent(this, DateActivity.class);
                intent.putExtra("uri", inputSource);
                startActivity(intent);
            }
            else{
                Toast.makeText(this,"데이터를 제대로 입력해주세요.",Toast.LENGTH_SHORT).show();
            }

        }
        else if(btnId==R.id.todayBtn){
            String regiontext=todayregion.getText().toString();
            if(regiontext!="") {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                Date time = new Date();
                String today = format.format(time);
                String inputSource = url + serviceKey + nexturl + today + "/" + regiontext;
                Intent intent = new Intent(this, TodayActivity.class);
                intent.putExtra("uri", inputSource);
                startActivity(intent);
            }
            else{
                Toast.makeText(this,"데이터를 제대로 입력해주세요.",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
