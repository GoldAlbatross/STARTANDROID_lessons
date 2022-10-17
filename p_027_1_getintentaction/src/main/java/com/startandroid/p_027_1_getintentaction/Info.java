package com.startandroid.p_027_1_getintentaction;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        Intent intent = getIntent();
        String action = intent.getAction();

        String template = "", textInf = "";

        if(action.equals("com.startandroid.intent.action.showtime")) {
            template = "HH:mm:ss";
            textInf = "Time\n\n";
        }
        if(action.equals("com.startandroid.intent.action.showdate")) {
            template = "dd.MM.yyyy";
            textInf = "Date\n\n";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(template);
        String dt = sdf.format(new Date(System.currentTimeMillis()));
        TextView tvInfo = findViewById(R.id.tvInfo);
        tvInfo.setText(textInf + dt);
    }
}