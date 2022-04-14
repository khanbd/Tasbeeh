package com.nhk.Tasbeeh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    AppCompatTextView txtTotal;
    AppCompatImageButton ibPlus, ibMinus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.actionbar);
        setContentView(R.layout.activity_main);

        setTitle("Tasbeeh");

        ibPlus = findViewById(R.id.imBtnPlus);
        ibMinus = findViewById(R.id.imBtnMinus);
        txtTotal = findViewById(R.id.txtTotal);

        ibPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = Integer.parseInt(txtTotal.getText().toString()) + 1;
                txtTotal.setText(String.valueOf (count));
            }
        });

        ibMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = Integer.parseInt(txtTotal.getText().toString()) - 1 ;
                if (count<0) count= 0;
                txtTotal.setText(String.valueOf (count));
            }
        });
    }

    public void setTitle(String title){
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = new TextView(this);
        textView.setText(title);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(textView);
    }
}