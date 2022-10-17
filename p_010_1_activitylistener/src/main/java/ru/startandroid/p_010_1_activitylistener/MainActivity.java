package ru.startandroid.p_010_1_activitylistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView tVOut;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View элементы
        tVOut = findViewById(R.id.tVOut);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        // присваиваем обработчик кнопкам
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (view.getId()) {
            case R.id.btnOk:
                tVOut.setText("Нажата кнопка Ок");
                break;
            case R.id.btnCancel:
                tVOut.setText("Нажата кнопка Cancel");
                break;
        }

    }
}