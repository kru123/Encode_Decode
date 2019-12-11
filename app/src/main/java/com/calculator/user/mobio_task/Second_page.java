package com.calculator.user.mobio_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second_page extends AppCompatActivity {
    private TextView t_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        t_result=(TextView)findViewById(R.id.result);
        display_output();
    }

    public void display_output(){
        Intent i = getIntent();
        String str = i.getStringExtra("message");
        t_result.setText(str);
    }
}
