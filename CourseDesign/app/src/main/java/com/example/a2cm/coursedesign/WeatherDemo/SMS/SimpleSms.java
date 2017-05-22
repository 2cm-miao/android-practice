package com.example.a2cm.coursedesign.WeatherDemo.SMS;

import java.text.SimpleDateFormat;

/**
 * Created by 2cm on 2017/5/22.
 */

public class SimpleSms {
    public String Sender;
    public String Body;
    public String ReceiverTime;
    public String ReturnResult;

    public SimpleSms(){
    }

    public SimpleSms(String sender,String body){
        this.Sender=sender;
        this.Body=body;
        SimpleDateFormat tempDate=new SimpleDateFormat("yyyy-MM-dd"+" "+"hh:mm:ss");
        this.ReceiverTime=tempDate.format(new java.util.Date());
        this.ReturnResult="";
    }
}
