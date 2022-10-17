package ru.startandroid.p_011_1resvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout bottom11 = findViewById(R.id.bottom11);
        TextView tvBottom = findViewById(R.id.tvBottom);
        Button btnBottom = findViewById(R.id.btnBottom);

        bottom11.setBackgroundResource(R.color.bottomColor);
        tvBottom.setText(R.string.tvBottom);
        btnBottom.setText(R.string.btnBottom);
    }
}
