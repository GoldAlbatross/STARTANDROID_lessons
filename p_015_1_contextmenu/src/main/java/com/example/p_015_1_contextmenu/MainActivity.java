package com.example.p_015_1_contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    TextView tvColor, tvSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvColor = findViewById(R.id.tvColor);
        tvSize = findViewById(R.id.tvSize);

        registerForContextMenu(tvColor);
        tvSize.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        switch (view.getId()) {
            case R.id.tvColor:
                menu.add(1,MENU_COLOR_RED,1,"Red");
                menu.add(0,MENU_COLOR_GREEN,0,"Green");
                menu.add(1,MENU_COLOR_BLUE,0,"Blue");
                break;
            case R.id.tvSize:
                menu.add(0,MENU_SIZE_22,0,"22");
                menu.add(0,MENU_SIZE_26,0,"26");
                menu.add(0,MENU_SIZE_30,0,"30");
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_COLOR_RED:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("x--Red--x");
                break;
            case MENU_COLOR_GREEN:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("x--Gren--x");
                break;
            case MENU_COLOR_BLUE:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("x--Blue--x");
                break;
            case MENU_SIZE_22:
                tvSize.setTextSize(22);
                tvSize.setText("x--22--x");
                break;
            case MENU_SIZE_26:
                tvSize.setTextSize(26);
                tvSize.setText("x--26--x");
                break;
            case MENU_SIZE_30:
                tvSize.setTextSize(30);
                tvSize.setText("x--30--x");
        }

        return super.onContextItemSelected (item);
    }
}