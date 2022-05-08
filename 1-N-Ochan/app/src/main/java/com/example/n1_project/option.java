package com.example.n1_project;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class option extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        TextView tv_result = (TextView)findViewById(R.id.tv_result);
        TextView tv_result2 = (TextView)findViewById(R.id.tv_result2);
        TextView tv_result3 = (TextView)findViewById(R.id.tv_result3);
        Spinner spinner3 = (Spinner)findViewById(R.id.spinner_3);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner);
        Spinner spinner2= (Spinner)findViewById(R.id.spinner_2);
        Button addBtn = findViewById(R.id.add_btn);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv_result.setText(adapterView.getItemAtPosition(i).toString());
            }//시간

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv_result2.setText(adapterView.getItemAtPosition(i).toString());
            }//위치

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv_result3.setText(adapterView.getItemAtPosition(i).toString());
            }//식당

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //입력값 변수 담기
                addUser(tv_result2.getText().toString(),tv_result3.getText().toString(), tv_result.getText().toString());

            }
        });
    }

    public void addUser(String rn,String time, String location) {
        User user = new User(rn,time,location);
        databaseReference.child("User").child("User_04").setValue(user);
    }
}