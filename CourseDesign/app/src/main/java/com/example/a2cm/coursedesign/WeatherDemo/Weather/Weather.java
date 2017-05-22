package com.example.a2cm.coursedesign.WeatherDemo.Weather;


import java.net.PortUnreachableException;

/**
 * Created by 2cm on 2017/5/22.
 */

public class Weather {
    public static String city;
    public static String province;
    public static String date;

    public static String current_weather;

    public static String current_temperature;
    public static String current_windD;

    public static String current_windP;

    public static String[] weatherD=new String[3];
    public static String[] weatherN=new String[3];

    public static String[] temperatureD=new String[3];
    public static String[] temperatureN=new String[3];
    public static String[] humidity=new String[3];
    public static String[] windDD=new String[3];
    public static String[] windDN=new String[3];

    public static String[] windPD=new String[3];
    public static String[] windPN=new String[3];

    public static String[] sunrise=new String[3];
    public static String[] sundown=new String[3];

    public static String GetSmsMsgD(){
        String msg="";
        msg+=city+",";
        msg+=weatherD[0]+","+temperatureD[0]+".";

        return msg;
    }

    public static String GetSmsMsgN(){
        String msg="";
        msg+=city+",";
        msg+=weatherN[0]+","+temperatureN[0]+".";

        return msg;
    }

    public static String GetSmsMsg(){
        String msg = "";
        msg += city + "，";
        msg+=weatherN[0]+","+temperatureN[0]+".";
        return msg;
    }
}
