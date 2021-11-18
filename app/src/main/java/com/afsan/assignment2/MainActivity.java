package com.afsan.assignment2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn1);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinneritems,android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        button1.setOnClickListener(v -> {
            String state = spinner.getSelectedItem().toString();
            changeActivity(state);
        });





    }
    public void changeActivity(String activity){
        Intent intent;

        if(activity.equals("Custom broadcast receiver")){
            intent = new Intent(this, NextActivity.class);
            intent.putExtra("opt","opt1");
            startActivity(intent);
        }
        else if(activity.equals("System battery notification receiver")){
            intent = new Intent(this, NextActivity.class);
            intent.putExtra("opt","opt2");
            startActivity(intent);
        }
        else{
            intent = new Intent(this, LastActivity.class);
            startActivity(intent);
        }

    }
}