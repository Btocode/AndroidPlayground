package com.afsan.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NextActivity extends AppCompatActivity {
    private Button btn;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent intent = getIntent();
        String optn = intent.getStringExtra("opt");

        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optn.equals("opt1")){
//                    System.out.println("Checked one");
                    intent.setAction("com.afsan.assignment2");
                    et = findViewById(R.id.tv1);
                    intent.putExtra("opt1",et.getText().toString());
                    sendBroadcast(intent);

                }
                else if (optn.equals("opt2")){
//                    System.out.println("Checked two");
                    intent.setAction("com.afsan.assignment2");
                    et = findViewById(R.id.tv1);
                    intent.putExtra("opt2",et.getText().toString());
                    sendBroadcast(intent);
                }
                else{
                    System.out.println("Checked three");
                }
            }
        });
    }
}