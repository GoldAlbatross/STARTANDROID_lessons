package com.startandroid.p_009_onclickbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // создаем переменные
    View tVOut;
    View btnOk;
    View btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // найдем View-элементы
        tVOut = findViewById(R.id.tVOut);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        // создаем обработчик нажатия
        View.OnClickListener oclOk = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)tVOut).setText("Нажата кнопка ОК!");
            }
        };
        View.OnClickListener oclCancel = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)tVOut).setText("Нажата кнопка Cancel!");
            }
        };

        // присвоим обработчик кнопке OK (btnOk)
        btnOk.setOnClickListener(oclOk);
        btnCancel.setOnClickListener(oclCancel);


    }
}