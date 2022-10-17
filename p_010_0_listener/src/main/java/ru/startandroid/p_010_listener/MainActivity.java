package ru.startandroid.p_010_listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tVOut;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // найдем View элементы
        tVOut = findViewById(R.id.tVOut);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        //создание обработчика
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // по id определеяем кнопку, вызвавшую этот обработчик
                switch (view.getId()) {
                    case R.id.btnOk:
                        tVOut.setText("Нажата кнопка ОК");
                        break;

                    case R.id.btnCancel:
                        tVOut.setText("Нажата кнопка Cancel");
                        break;
                }

            }
        };
        btnOk.setOnClickListener(listener);
        btnCancel.setOnClickListener(listener);
    }
}