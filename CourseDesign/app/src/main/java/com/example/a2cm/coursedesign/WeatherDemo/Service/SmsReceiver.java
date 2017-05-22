package com.example.a2cm.coursedesign.WeatherDemo.Service;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.example.a2cm.coursedesign.WeatherDemo.SMS.SimpleSms;
import com.example.a2cm.coursedesign.WeatherDemo.DB.Config;

/**
 * Created by 2cm on 2017/5/22.
 */

public class SmsReceiver extends BroadcastReceiver {
    private static final String SMS_ACTINO="android.provider.Telephony.SMS_RECEIVED";

    @TargetApi(23)
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(SMS_ACTINO)){
            Bundle bundle=intent.getExtras();
            if(bundle!=null){
                Object[] objs=(Object[])bundle.get("pdus");
                String format = intent.getStringExtra("format");
                SmsMessage[] messages=new SmsMessage[objs.length];
                for(int i=0;i<objs.length;i++){
                    messages[i]=SmsMessage.createFromPdu((byte[])objs[i],format);
                }

                String smsBody = messages[0].getDisplayMessageBody();
                String smsSender =  messages[0].getDisplayOriginatingAddress();
                if (smsBody.trim().equals(Config.KeyWord) && Config.ProvideSmsService.equals("true")){
                    SimpleSms simpleSms = new SimpleSms(smsSender, smsBody);
                    WeatherService.RequerSMSService(simpleSms);
                    Toast.makeText(context, "接收到服务请求短信", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
