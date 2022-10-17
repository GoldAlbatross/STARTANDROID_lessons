package com.startandroid.p_027_1_getintentaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnT = findViewById(R.id.btnT);
        btnT.setOnClickListener(this);

        Button btnD = findViewById(R.id.btnD);
        btnD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnD:
                intent = new Intent("com.startandroid.intent.action.showdate");
                startActivity(intent);
                break;
            case R.id.btnT:
                intent = new Intent("com.startandroid.intent.action.showtime");
                startActivity(intent);
                break;

        }

    }
}