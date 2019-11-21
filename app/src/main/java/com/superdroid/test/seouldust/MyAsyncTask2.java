package com.superdroid.test.seouldust;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MyAsyncTask2 extends AsyncTask<Void, Integer, Boolean> {

    TextView data1,data2,error;
    String d1="",d2="";
    String url="";
    public MyAsyncTask2(TextView data1,TextView data2,String url,TextView error)
    {
        this.data1=data1;
        this.data2=data2;
        this.url=url;
        this.error=error;
    }

    @Override
    protected Boolean doInBackground(Void... strings){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url);
            doc.getDocumentElement().normalize();
            NodeList nList1 = doc.getElementsByTagName("PM10");
            Node nNode1 = nList1.item(0);
            Element eElement1 = (Element)nNode1;
            d1 = eElement1.getTextContent();
            NodeList nList2 = doc.getElementsByTagName("PM25");
            Node nNode2 = nList2.item(0);
            Element eElement2 = (Element)nNode2;
            d2 = eElement2.getTextContent();





        }catch(Exception e){
            Log.d("superdroid",e.toString());
        }

        return true;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean s) {
        data1.setText(d1);
        data2.setText(d2);
        if(d1=="")
            error.setText("데이터 로드 에러가 발생했습니다. 조금 후에 다시 시도해주세요.");
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Boolean s) {
        super.onCancelled(s);
    }
}