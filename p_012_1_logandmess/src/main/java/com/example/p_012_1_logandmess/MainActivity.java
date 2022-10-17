package com.example.p_012_1_logandmess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.d("!@#","findById");
        tvOut = findViewById(R.id.tvOut);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
        Toast.makeText(this, "findViewById is successful", Toast.LENGTH_LONG).show();

        Log.d("!@#","set on click");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        Toast.makeText(this, "set on click is successful", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnOk:
                Log.d("!@#","set ok");
                tvOut.setText("OK");
                Toast.makeText(this, "set ok", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCancel:
                Log.d("!@#","set cancel");
                tvOut.setText("Cancel");
                Toast.makeText(this, "set cancel", Toast.LENGTH_LONG).show();
                break;
        };
    }
}