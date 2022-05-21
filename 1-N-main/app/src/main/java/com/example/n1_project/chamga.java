package com.example.n1_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class chamga extends AppCompatActivity {
    TextView detail_idtext;
    String location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamga);
        detail_idtext = findViewById(R.id.detail_id_text);
        Intent intent77 = getIntent();
        location = intent77.getExtras().getString("location");

        detail_idtext.setText(location);
    }
}