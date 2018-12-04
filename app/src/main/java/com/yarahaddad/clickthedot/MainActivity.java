package com.yarahaddad.clickthedot;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity
{

    public static final String EXTRA_MESSAGE = "com.yarahaddad.clickthedot.MESSAGE";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LogIn(View view) {
        Intent intent = new Intent(this, Menu.class);
        EditText editText;
        editText = findViewById(R.id.editText);
        String userName = editText.getText().toString();
        editText = findViewById(R.id.editText2);
        String password = editText.getText().toString();

        if(userName.isEmpty()||password.isEmpty())
            Message.message(getApplicationContext(),"Empty Field");
        else
        if (!userName.equals(password))
            Message.message(getApplicationContext(),"UserName and Password are not equal");
        else
        {
            intent.putExtra(EXTRA_MESSAGE, userName);
            startActivity(intent);
        }
    }


}

