package com.yarahaddad.clickthedot;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

public class PlayGame extends AppCompatActivity {

    public CountDownTimer timer;
    public long timeLeft = 3000;
    public int score;
    String userName;
    int move;
    int[] cor;
    Date currentTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        score=0;
        move=0;
        currentTime = Calendar.getInstance().getTime();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_game);

        Intent intent = getIntent();
        String msg=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String[] info=msg.split("   ");
        userName = info[0];

        timer=addTimer(timeLeft);
        updateScore();

        final FloatingActionButton button = findViewById(R.id.floatingActionButton4);
        cor=addDot(button);

        LogToFile("New Game!! Player "+userName +" starts to play."+ "\n"+"Initial dot coordinates are:["+cor[0]+","+cor[1]+"]");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.hide();
               timeLeft= (long) (timeLeft*0.95);
                timer.cancel();
                timer=addTimer(timeLeft);
                int[] newCor=addDot(button);
                score++;
                move++;
                LogToFile("player "+userName+" plays move number: "+move);
                LogToFile("Dot's new coordinates are:["+newCor[0]+","+newCor[1]+"]");
                cor=newCor;
                updateScore();


            }
        });
    }
@Override
protected  void onPause() {
    super.onPause();
    timer.cancel();
}

    public int[] addDot(FloatingActionButton button )
    {
        AbsoluteLayout.LayoutParams absParams =
                (AbsoluteLayout.LayoutParams)button.getLayoutParams();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;


        Random r = new Random();
        int[] cor=new int[2];
        cor[0]=r.nextInt(width-3*button.getWidth() )+button.getWidth();
        cor[1]=r.nextInt((height-6*button.getHeight()))+button.getHeight();
        absParams.x =  cor[0] ;
        absParams.y =  cor[1];
        button.show();
        button.setLayoutParams(absParams);
        return cor;

    }

    public CountDownTimer addTimer(final long time)
    {
         CountDownTimer timer=new CountDownTimer(time, 100) {
            TextView timerView=findViewById(R.id.textView6);
            public void onTick(long millisUntilFinished) {
                timerView.setText("seconds remaining: " + millisUntilFinished / 1000 + ":" + millisUntilFinished % 1000 );

            }

            public void onFinish() {
                timerView.setText("done!");
                gameOver();


            }
        }.start();
        return timer;
    }

    public void updateScore()
    {
        TextView scoreView=findViewById(R.id.textView7);
        scoreView.setText(" score: " + score);
    }

    public void gameOver()
    {
        Intent intent = new Intent(this, GameOver.class);
        String scr=Integer.toString(score);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, userName + "    " +currentTime.toString()+"    "+scr);
        startActivity(intent);
    }

    public void LogToFile(String data)
    {
        try {
            String[] files=fileList();
            boolean found=false;
            FileOutputStream fileout;
            for ( String file : files) {
                if (file.equals("Logs.txt"))
                {
                    found=true;
                }
            }
            if(!found) {
                fileout= openFileOutput("Logs.txt", Context.MODE_PRIVATE);
            }
            else
            {
                fileout=openFileOutput("Logs.txt",Context.MODE_APPEND);
            }

            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(data);
            outputWriter.write("\n");
            outputWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}
