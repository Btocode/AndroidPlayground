package com.afsan.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NextActivity extends AppCompatActivity {
    private Button btn;
    private EditText et;
    private String optn;

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent i = new Intent(context, LastActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("message", et.getText().toString());
            i.putExtra("optn", optn);
            context.startActivity(i);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent intent = getIntent();
        optn = intent.getStringExtra("opt");
        TextView tv2 = findViewById(R.id.textView2);
        et = findViewById(R.id.tv1);
        if (optn.equals("opt1")){
            tv2.setText("Enter anything you want");
        }
        else {
            tv2.setText("Enter battery Percentage");
        }

        IntentFilter ip = new IntentFilter("com.afsan.assignment2.txt");
        registerReceiver(br,ip);

        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optn.equals("opt1")){
//                    System.out.println("Checked one
                    Intent rand = new Intent("com.afsan.assignment2.txt");
                    NextActivity.this.sendBroadcast(rand);

                }
                else if (optn.equals("opt2")){
//                    System.out.println("Checked two");
                    Intent rand = new Intent("com.afsan.assignment2.txt");
                    NextActivity.this.sendBroadcast(rand);

                }
                else{
//                    Do Nothing
                }
            }
        });
    }
}