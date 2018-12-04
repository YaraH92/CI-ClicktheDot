package com.yarahaddad.clickthedot;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    Button clk;
    VideoView videov;
    MediaController m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        clk=findViewById(R.id.button11);
        videov=findViewById(R.id.videoView);

    }

    public void videoplay (View view) {
//        m = new MediaController(this);
//        String videoPath="android.resource://com.yarahaddad.clickthedot/"+R.raw.videoplayback;
//        Uri u = Uri.parse(videoPath);
//
//        videov.setVideoURI(u);
//
//        videov.start();


    }
}
