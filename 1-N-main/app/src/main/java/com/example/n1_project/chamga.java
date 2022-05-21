package com.example.n1_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class chamga extends AppCompatActivity {

    private Intent intent22;
    String mlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamga);

        intent22 = getIntent();
        mlocation = intent22.getStringExtra("mlocation");
    }
}