package com.yarahaddad.clickthedot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        userName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView4);
        textView.setText(userName);
    }

    public void playGame(View view) {
        Intent intent = new Intent(this, PlayGame.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, userName);
        startActivity(intent);

    }

    public void viewRecords(View view) {
        Intent intent = new Intent(this, Records.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, userName);
        startActivity(intent);
    }

    public void viewLogs(View view) {
        Intent intent = new Intent(this, Logs.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, userName);
        startActivity(intent);
    }

    public void Video(View view) {
        Intent intent = new Intent(this, Video.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, userName);
        startActivity(intent);
    }

    public void logOut(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
