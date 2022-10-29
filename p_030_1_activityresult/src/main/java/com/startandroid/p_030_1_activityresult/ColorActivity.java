package com.startandroid.p_030_1_activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnR, btnG, btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color);

        btnR = findViewById(R.id.btnRed);
        btnG = findViewById(R.id.btnGreen);
        btnB = findViewById(R.id.btnBlue);

        btnR.setOnClickListener(this);
        btnG.setOnClickListener(this);
        btnB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnRed:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.btnGreen:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.btnBlue:
                intent.putExtra("color", Color.BLUE);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();

    }
}