package com.calculator.user.mobio_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private Button b_encrypte,b_decrypte,b_submit;
    private String input_string;
    boolean m_encrypte,m_decrypte;
    private EditText e_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_encrypte=(Button) findViewById(R.id.encrypte);
        b_decrypte=(Button) findViewById(R.id.decrypte);
        b_submit=(Button) findViewById(R.id.submit);
        e_input=(EditText) findViewById(R.id.input_text);
        buttonclicked();

      b_submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


                if (m_encrypte == true){
                    input_string = e_input.getText().toString();
                    Intent intent = new Intent(MainActivity.this,Second_page.class);
                    intent.putExtra("message", compressString(input_string));
                    startActivity(intent);
                    e_input.setText("");
                    m_encrypte=false;
                }
                else if (m_decrypte == true){
                    input_string = e_input.getText().toString();
                    Intent intent = new Intent(MainActivity.this,Second_page.class);
                    intent.putExtra("message",  decompressString(input_string));
                    startActivity(intent);
                    e_input.setText("");
                    m_decrypte=false;

                }



           }

        });

    }


    public String compressString(String data){
        StringBuilder outBuilder = new StringBuilder();
        int n=data.length();
        for (int i = 0; i < n; i++) {


            int count = 1;
            while (i < n - 1 &&
                    data.charAt(i) == data.charAt(i + 1)) {
                count++;
                i++;
            }
            outBuilder.append(data.charAt(i));
            outBuilder.append(count);

        }

        return outBuilder.toString();
    }

    public String decompressString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            int count = Integer.valueOf("" + str.charAt(i + 1));
            for (int j = 0; j < count; j++) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }

    public void buttonclicked(){

        b_encrypte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_string = e_input.getText().toString();
                if (input_string.matches("") ) {
                    Toast.makeText(getApplicationContext(),"Please enter the String",Toast.LENGTH_SHORT).show();
                } else {
                    m_encrypte=true;



                }
            }
        });


        b_decrypte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_string = e_input.getText().toString();
                if (input_string.matches("") ) {
                    Toast.makeText(getApplicationContext(),"Please enter the String",Toast.LENGTH_SHORT).show();

                } else {
                    m_decrypte=true;




                }
            }
        });

    }





}
