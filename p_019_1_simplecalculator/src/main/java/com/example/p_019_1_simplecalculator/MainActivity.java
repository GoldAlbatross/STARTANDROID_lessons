package com.example.p_019_1_simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET = 1;
    final int MENU_QUIT = 2;

    EditText num1, num2;
    Button btnadd, sub, mult, div;
    TextView tvResult;
    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        btnadd = findViewById(R.id.btnadd);
        btnadd.setOnClickListener(this);
        sub = findViewById(R.id.sub);
        sub.setOnClickListener(this);
        mult = findViewById(R.id.mult);
        mult.setOnClickListener(this);
        div = findViewById(R.id.div);
        div.setOnClickListener(this);

        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    public void onClick(View view) {
        double x;
        double y;
        double result;

        if (TextUtils.isEmpty(num1.getText().toString()) || TextUtils.isEmpty(num2.getText().toString())) {
            return;
        }

        x = Double.parseDouble(num1.getText().toString());
        y = Double.parseDouble(num2.getText().toString());

        switch (view.getId()) {
            case R.id.btnadd:
                oper = "+";
                result= x+y;
                tvResult.setText(x + " " + oper + " " + y + " = " + Math.round(result*100)/100.0d);
                break;
            case R.id.sub:
                oper = "-";
                result = x-y;
                tvResult.setText(x + " " + oper + " " + y + " = " + Math.round(result*100)/100.0d);
                break;
            case R.id.mult:
                oper = "*";
                result = x*y;
                tvResult.setText(x + " " + oper + " " + y + " = " + Math.round(result*100)/100.0d);
                break;
            case R.id.div:
                oper = "/";
                if (y!=0) {
                    result = x/y;
                    tvResult.setText(x + " " + oper + " " + y + " = " + Math.round(result*100)/100.0d);
                }
                else tvResult.setText("Ты дурак!");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET, 0, "reset");
        menu.add(0, MENU_QUIT, 0, "quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET:
                num1.setText("");
                num2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}