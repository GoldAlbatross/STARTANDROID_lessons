package com.example.p_008_viewbuild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        View myTextView = findViewById(R.id.myText);
        ((TextView)myTextView).setText ("New text in TextView");

        Button myBtn = findViewById(R.id.btn);
        myBtn.setText("Knopka");
        myBtn.setEnabled(false);

        CheckBox mychB = findViewById(R.id.chB);
        mychB.setChecked(true);
    }
}