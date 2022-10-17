package com.example.p_020_1_simpleanimation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int MENU_ALFA = 1;
    final int MENU_SCALE = 2;
    final int MENU_TRANSLATE = 3;
    final int MENU_ROTATE = 4;
    final int MENU_COMBO = 5;

    ImageView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv = findViewById(R.id.tv);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        switch (view.getId()) {
            case R.id.tv:
                menu.add(0, MENU_ALFA, 0, "alfa");
                menu.add(0, MENU_SCALE, 0, "scale");
                menu.add(0, MENU_TRANSLATE, 0, "translate");
                menu.add(0, MENU_ROTATE, 0, "rotate");
                menu.add(0, MENU_COMBO, 0, "combo");
                break;
        }
        super.onCreateContextMenu(menu, view, info);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;
        switch (item.getItemId()) {
            case MENU_ALFA:
                anim = AnimationUtils.loadAnimation(this, R.anim.my_alfa);
                break;
            case MENU_ROTATE:
                anim = AnimationUtils.loadAnimation(this, R.anim.my_rotate);
                break;
            case MENU_SCALE:
                anim = AnimationUtils.loadAnimation(this, R.anim.my_scale);
                break;
            case MENU_TRANSLATE:
                anim = AnimationUtils.loadAnimation(this, R.anim.my_trans);
                break;
            case MENU_COMBO:
                anim = AnimationUtils.loadAnimation(this, R.anim.my_combo);
                break;
        }
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}