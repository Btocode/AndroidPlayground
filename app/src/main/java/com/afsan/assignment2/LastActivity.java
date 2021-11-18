package com.afsan.assignment2;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    private TextView tv;
    private String message;
    private String key;
    BroadcastReceiver br3 = new BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {

            if(key.equals("opt2")){
                int level = intent.getIntExtra("level",0);
                TextView txt = findViewById(R.id.textView2);
                tv.setText("User Input: " +message+"%\n" +"Actual Battery Level: " + Integer.toString(level) + "%");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        IntentFilter xp = new IntentFilter("com.afsan.assignment2.txt");
        registerReceiver(br3,xp);

        Intent intent = getIntent();
        message = intent.getStringExtra("message");
        key = intent.getStringExtra("optn");
        tv = findViewById(R.id.textView);


        if ("opt1".equals(key)){
            tv.setText(message);
        }
        else if("opt2".equals(key)){
            registerReceiver(br3,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        }
        else{
            tv.setText("Failed to implement this feature.");
        }
    }
}