package com.example.p_016_1_dynamiclayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.util.Size;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        setContentView(ll,params);

        LinearLayout.LayoutParams paramsView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(this);
        tv.setText("x--my text--x");
        tv.setTextSize(30);
        tv.setLayoutParams(paramsView);
        ll.addView(tv);

        Button bt = new Button(this);
        bt.setText("(*_*)");
        bt.setLayoutParams(paramsView);
        ll.addView(bt, paramsView);

        LinearLayout.LayoutParams leftMargin = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams gravity = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        leftMargin.leftMargin = 50;
        Button bt1 = new Button(this);
        bt1.setText("(*_*)   button1");
        ll.addView(bt1, leftMargin);

        gravity.gravity = Gravity.CENTER;
        Button bt2 = new Button(this);
        bt2.setText("(*_*)   button2");
        ll.addView(bt2, gravity);

    }
}