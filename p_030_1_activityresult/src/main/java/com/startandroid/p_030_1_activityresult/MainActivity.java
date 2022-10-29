package com.startandroid.p_030_1_activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGNMENT = 2;
    TextView tv;
    Button btnColor, btnAlign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv = findViewById(R.id.tv);
        btnColor = findViewById(R.id.btnColor);
        btnColor.setOnClickListener(this);
        btnAlign = findViewById(R.id.btnAlign);
        btnAlign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnColor:
                intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;
            case R.id.btnAlign:
                intent = new Intent(this, AlignmentActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGNMENT);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.d("myLogs", " -> requestCode=" + requestCode + ", resultCode=" + resultCode);
        if (resultCode != RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    int color = data.getIntExtra("color", Color.WHITE);
                    tv.setText(color);
                    break;
                case REQUEST_CODE_ALIGNMENT:
                    int alignment = data.getIntExtra("alignment", Gravity.LEFT);
                    tv.setGravity(alignment);
                    break;
            }
        } else
            Toast.makeText(this, "wrong result", Toast.LENGTH_SHORT).show();
    }
}