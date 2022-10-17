package com.startandroid.p_028_1_intentextras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        tv = findViewById(R.id.tv);

        Intent intent = getIntent();

        String firstname = intent.getStringExtra("firstname");
        String lastname = intent.getStringExtra("lastname");

        tv.setText("Your name is:\n" + firstname + " " + lastname);
    }
}