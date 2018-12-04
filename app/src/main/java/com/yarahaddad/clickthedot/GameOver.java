package com.yarahaddad.clickthedot;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GameOver extends AppCompatActivity {

    String score;
    String userName;
    String time;
    String filename1="Records.txt";
    String filename2="Logs.txt";

    public GameOver() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String[] info=msg.split("   ");
        score = info[2];
        time=info[1];
        userName=info[0];
        TextView textView = findViewById(R.id.textView8);
        textView.setText("your score is: " + score );
        String data1=userName+"   "+score+"   "+time;
        String data2="Game Over!! player "+userName+" got " + score+" points."+"\n";
        writeToFile(data1,filename1);
        writeToFile(data2,filename2);

         //readFile();
}


    private void writeToFile(String data, String filename)
    {
        try {
            String[] files=fileList();
            boolean found=false;
            FileOutputStream fileout;
            for ( String file : files) {
                if (file.equals(filename))
                {
                    found=true;
                }
            }
            if(!found) {
                fileout= openFileOutput(filename, Context.MODE_PRIVATE);
            }
            else
            {
                fileout=openFileOutput(filename,Context.MODE_APPEND);
            }

            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(data);
            outputWriter.write("\n");
            outputWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void play(View view)
    {
        Intent intent = new Intent(this, PlayGame.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE,userName + "    " +score);
        startActivity(intent);
    }

    public void menu(View view)
    {
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE,userName);
        startActivity(intent);
    }
}
