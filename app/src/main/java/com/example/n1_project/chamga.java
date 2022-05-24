package com.example.n1_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class chamga extends AppCompatActivity {
    private Intent intent44;
    String tv_tm2;
    String tv_lc2;
    String tv_rn2;
    TextView textView4;
    TextView textView5;
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamga);

        intent44 = getIntent();
        tv_tm2 = intent44.getStringExtra("tv_tm2");
        intent44 = getIntent();
        tv_lc2 = intent44.getStringExtra("tv_lc2");
        intent44 = getIntent();
        tv_rn2 = intent44.getStringExtra("tv_rn2");
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView4.setText(tv_lc2);
        textView5.setText(tv_rn2);
        textView6.setText(tv_tm2);

    }
}