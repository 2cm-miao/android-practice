package com.example.a2cm.androidtext33;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sub_MainActivity extends AppCompatActivity {
    int ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity_main);

        Button btn1=(Button)findViewById(R.id.button2);
        Button btjia=(Button)findViewById(R.id.btnjia);
        Button btjian=(Button)findViewById(R.id.btnjian);
        Button btcheng=(Button)findViewById(R.id.btncheng);
        Button btchu=(Button)findViewById(R.id.btnchu);
        TextView text1=(TextView)findViewById(R.id.num1);
        TextView text2=(TextView)findViewById(R.id.num2);

        String nu1 = getIntent().getStringExtra("a");
        String nu2 = getIntent().getStringExtra("b");
        text1.setText(nu1);
        text2.setText(nu2);
        final int nn = Integer.valueOf(nu1);
        final int mm = Integer.valueOf(nu2);

        btjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans=nn+mm;
            }
        });
        btjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans=mm-nn;
            }
        });
        btcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans=nn*mm;
            }
        });
        btchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nn==0)  ans=0;
                else  ans=mm/nn;
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uriString=""+ans;
                Uri data= Uri.parse(uriString);
                Intent result=new Intent(null,data);
                setResult(RESULT_OK,result);
                finish();
            }
        });
    }
}
