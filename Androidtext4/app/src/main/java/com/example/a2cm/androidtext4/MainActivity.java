package com.example.a2cm.androidtext4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Handler handler=new Handler();
    private static TextView labelView=null;
    private static String answer;

    public static void UpdateGUI(String refreshString){
        answer=refreshString;
        handler.post(RefreshLable);
    }

    private static Runnable RefreshLable=new Runnable() {
        @Override
        public void run() {
            labelView.setText(answer);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelView=(TextView)findViewById(R.id.textView);
        Button btn=(Button)findViewById(R.id.count);
        final EditText num1=(EditText)findViewById(R.id.num1);
        final EditText num2=(EditText)findViewById(R.id.num2);
        final Intent serviceIntent=new Intent(this,MathService.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1=num1.getText().toString();
                String n2=num2.getText().toString();

                serviceIntent.putExtra("a",n1);
                serviceIntent.putExtra("b",n2);

                startService(serviceIntent);
            }
        });
    }
}
