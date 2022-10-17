package com.example.p_017_1_dynamiclayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout main;
    RadioGroup radio_group;
    EditText edit_text;
    Button create, delete;

    int wr = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        main = findViewById(R.id.main);
        radio_group = findViewById(R.id.first_group);
        edit_text = findViewById(R.id.edit_text);

        create = findViewById(R.id.create);
        create.setOnClickListener(this);

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View Button) {
        switch (Button.getId()) {
            case R.id.create:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wr,wr);
                int btnGravity = Gravity.CENTER;
                switch (radio_group.getCheckedRadioButtonId()) {
                    case R.id.left:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.center:
                        btnGravity = Gravity.CENTER;
                        break;
                    case R.id.right:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                layoutParams.gravity = btnGravity;
                Button btnNew = new Button(this);
                btnNew.setText(edit_text.getText().toString());
                main.addView(btnNew, layoutParams);
                break;
            case R.id.delete:
                main.removeAllViews();
                Toast.makeText(this,"Deletion completed", Toast.LENGTH_LONG).show();
                break;
        }
    }
}