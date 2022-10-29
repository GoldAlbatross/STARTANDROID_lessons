package com.startandroid.p_030_1_activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignmentActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnL, btnC, btnR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alignment);

        btnL = findViewById(R.id.btnLeft);
        btnC = findViewById(R.id.btnCenter);
        btnR = findViewById(R.id.btnRight);

        btnL.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnR.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnLeft:
                intent.putExtra("alignment", Gravity.LEFT);
                break;
            case R.id.btnCenter:
                intent.putExtra("alignment", Gravity.CENTER);
                break;
            case R.id.btnRight:
                intent.putExtra("alignment", Gravity.RIGHT);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();

    }
}