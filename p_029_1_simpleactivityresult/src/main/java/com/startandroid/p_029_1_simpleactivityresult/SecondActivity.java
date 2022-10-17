package com.startandroid.p_029_1_simpleactivityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etSecond;
    Button btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        etSecond = findViewById(R.id.etSecond);
        btnSecond = findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", " " + etSecond.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }
}