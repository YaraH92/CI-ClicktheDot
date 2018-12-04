package com.yarahaddad.clickthedot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Logs extends AppCompatActivity {

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        Intent intent = getIntent();
        userName=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView9);
        String logs=readFile();
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(logs);


    }

    public String readFile(){
        //reading text from file
        String logs="";
        try {
            FileInputStream fileIn=openFileInput("Logs.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);
            BufferedReader reader = new BufferedReader(InputRead);
            String line;
            while((line=reader.readLine())!=null)
            {

                logs+=line;
                logs+="\n";

            }

            InputRead.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return logs;
    }

    public void back(View view)
    {
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE,userName);
        startActivity(intent);
    }
}
