package com.example.a2cm.androidtext4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by 2cm on 2017/4/28.
 */

public class MathService extends Service{
   private Thread workThread;

    String num1;
    String num2;

    @Override
    public void onCreate() {
        super.onCreate();
        workThread=new Thread(null,backgroudWork,"WorkThread");
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        if(!workThread.isAlive()){
            workThread.start();
        }

        num1=intent.getStringExtra("a");
        num2=intent.getStringExtra("b");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        workThread.interrupt();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private Runnable backgroudWork=new Runnable() {
        @Override
        public void run() {
            try {
                while(!Thread.interrupted()){
                    int n1=Integer.valueOf(num1);
                    int n2=Integer.valueOf(num2);
                    int nut=-1;
                    String ans=" ";

                    if(n1>n2){
                        int k=n1;
                        n1=n2;
                        n2=k;
                    }

                    for(int i=n1;i<=n2;i++){
                        boolean f=true;
                        for(int j=2;j<i;j++){
                            if(i%j==0){
                                f=false;
                                break;
                            }
                        }
                        if(f){
                            nut=i;
                            ans+=nut+""+" ";
                            MainActivity.UpdateGUI(ans);
                            Thread.sleep(1000);
                        }else{
                            continue;
                        }
                    }

                    onDestroy();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
}
