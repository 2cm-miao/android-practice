package com.example.a2cm.androidtext2;

import android.nfc.Tag;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static String TAG="LIFTCYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"(1)onCreate");

        //定义按钮和按钮监听函数，通过用户点击按钮调用finish()函数结束程序
        Button button=(Button)findViewById(R.id.btn_finish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //可视生命周期开始时被调用，对用户界面进行必要的更改
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"(2)onStart()");
    }

    //在onStart()后被调用，用于恢复onSaveInstanceState()保存的用户界面信息
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"(3)onRestoreInstanceState()");
    }

    //在活动生命周期开始时被调用，恢复被onPause()停止的用于界面更新的资源
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"(4)onResume()");
    }

    //在onPause()后被调用，保存界面临时信息
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG,"(5)onSaveInstanceState()");
    }

    //在重新进入可视生命周期前被调用，载入界面所需要的更改信息
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"(6)onRestart()");
    }

    //在活动生命周期结束时被调用，用来保存持久的数据或释放占用的资源
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"（7)onPause()");
    }

    //在可视生命周期结束时被调用，用来释放占用的资源
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"（8)onStop()");
    }

    //在完全生命周期结束时被调用，释放资源，包括线程、数据连接等
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"（9)onDestroy()");
    }
}
