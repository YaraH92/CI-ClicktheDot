package com.yarahaddad.clickthedot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Records extends AppCompatActivity {

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        Intent intent = getIntent();
        userName=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        System.out.println(userName);

        TextView textView = findViewById(R.id.textView9);
        String Rec=readFile();
        System.out.println(Rec);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(Rec);


    }

    public String readFile(){
        //reading text from file
        String Rec="";
        try {
            FileInputStream fileIn=openFileInput("Records.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);
            BufferedReader reader = new BufferedReader(InputRead);
            String line;
            String[] info;
            while((line=reader.readLine())!=null)
            {
                info=line.split("   ");

                    Rec+="User:"+info[0]+"  "+"score:" + info[1];
                    Rec+="\n";

            }

            InputRead.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Rec;
    }

    public void back(View view)
    {
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE,userName);
        startActivity(intent);
    }

}
