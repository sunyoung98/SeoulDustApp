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

public class MyAsyncTask extends AsyncTask<Void, Integer, Boolean> {

    TextView data1,data2,data3,data4,data5,data6, error;
    String d1="",d2="",d3="",d4="",d5="",d6="";
    String url="";
    public MyAsyncTask(TextView data1,TextView data2,TextView data3,TextView data4,TextView data5,TextView data6,String url,TextView error)
    {
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
        this.data4=data4;
        this.data5=data5;
        this.data6=data6;
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
            NodeList nList1 = doc.getElementsByTagName("NO2");
            Node nNode1 = nList1.item(0);
            Element eElement1 = (Element)nNode1;
            d1 = eElement1.getTextContent();
            NodeList nList2 = doc.getElementsByTagName("O3");
            Node nNode2 = nList2.item(0);
            Element eElement2 = (Element)nNode2;
            d2 = eElement2.getTextContent();
            NodeList nList3 = doc.getElementsByTagName("CO");
            Node nNode3 = nList3.item(0);
            Element eElement3 = (Element)nNode3;
            d3 = eElement3.getTextContent();
            NodeList nList4 = doc.getElementsByTagName("SO2");
            Node nNode4 = nList1.item(0);
            Element eElement4 = (Element)nNode4;
            d4 = eElement4.getTextContent();
            NodeList nList5 = doc.getElementsByTagName("PM10");
            Node nNode5 = nList1.item(0);
            Element eElement5 = (Element)nNode5;
            d5 = eElement5.getTextContent();
            NodeList nList6 = doc.getElementsByTagName("PM25");
            Node nNode6 = nList1.item(0);
            Element eElement6 = (Element)nNode6;
            d6 = eElement6.getTextContent();




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
        data3.setText(d3);
        data4.setText(d4);
        data5.setText(d5);
        data6.setText(d6);
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