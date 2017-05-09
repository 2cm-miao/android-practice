package com.example.a2cm.androidtext33;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int key=1;
    TextView textView;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView2);
        Button btn=(Button)findViewById(R.id.button);
        editText1=(EditText)findViewById(R.id.num11);
        editText2=(EditText)findViewById(R.id.num22);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Sub_MainActivity.class);
                String n1=editText1.getText().toString();
                String n2=editText2.getText().toString();
                intent.putExtra("a",n1);
                intent.putExtra("b",n2);
                startActivityForResult(intent,key);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case key:
                if(resultCode==RESULT_OK){
                    Uri uriData=data.getData();
                    textView.setText(uriData.toString());
                }
                break;
        }
    }
}
