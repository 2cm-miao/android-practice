package com.example.a2cm.coursedesign.WeatherDemo.Service;

import java.util.ArrayList;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;

import com.example.a2cm.coursedesign.WeatherDemo.DB.Config;
import com.example.a2cm.coursedesign.WeatherDemo.DB.DBAdapter;
import com.example.a2cm.coursedesign.WeatherDemo.SMS.SimpleSms;
import com.example.a2cm.coursedesign.WeatherDemo.Weather.Weather;

/**
 * Created by 2cm on 2017/5/22.
 */

public class WeatherService extends Service{
    private DBAdapter dbAdapter ;
    private Thread workThread;

    private static ArrayList<SimpleSms> smsList = new ArrayList<SimpleSms>();
    private static int timeCounter = 1;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void RequerSMSService(SimpleSms sms){
        if (Config.ProvideSmsService.equals("true")){
            smsList.add(sms);
        }
    }

    private Runnable backgroudWork=new Runnable() {
        @Override
        public void run() {
            try{
                while(!Thread.interrupted()){
                    ProcessSmsList();
                    GetWeatherData();
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };

    private void ProcessSmsList(){
        if(smsList.size()==0){
            return ;
        }

        SmsManager smsManager=SmsManager.getDefault();
        PendingIntent mPi=PendingIntent.getBroadcast(this,0,new Intent(),0);
        while(smsList.size()>0){
            SimpleSms sms=smsList.get(0);
            smsList.remove(0);
            smsManager.sendTextMessage(sms.Sender,null,Weather.GetSmsMsg(),mPi,null);
            sms.ReturnResult= Weather.GetSmsMsg();
            SaveSmsData(sms);
        }
    }

    private void GetWeatherData(){

    }

    private void SaveSmsData(SimpleSms sms){

    }
}
