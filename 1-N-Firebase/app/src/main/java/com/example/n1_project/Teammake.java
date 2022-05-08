////https://github.com/bootpay/android/blob/main/app/src/main/java/kr/co/bootpay/android/WebAppActivity.java

package com.example.n1_project;

import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Teammake extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teammake);
    }

    public void goNativeActivity(View v) {
        Intent intent = new Intent(getApplicationContext(), NativeActivity.class);
        startActivity(intent);
    }

    public void goWebAppActivity(View v) {
        Intent intent = new Intent(getApplicationContext(), WebAppActivity.class);
        startActivity(intent);
    }
}