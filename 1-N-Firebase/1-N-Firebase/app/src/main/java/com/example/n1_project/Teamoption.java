package com.example.n1_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class Teamoption extends AppCompatActivity {


    private TextView tv_result;
    private TextView tv_result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamoption);
        TextView tv_result = (TextView)findViewById(R.id.tv_result);
        TextView tv_result2 = (TextView)findViewById(R.id.tv_result2);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner);
        Spinner spinner2= (Spinner)findViewById(R.id.spinner_2);
        Button addBtn = findViewById(R.id.add_btn);
        DAOUser dao = new DAOUser();
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv_result.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv_result2.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //입력값 변수 담기
                String time =  tv_result.getText().toString(); // 시간
                String location = tv_result2.getText().toString(); // 위치

                User user = new User("",time,location);
                //데이터베이스 사용자 등록
                dao.add(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_SHORT).show();
                        //입력창 초기화
                        tv_result.setText("");
                        tv_result2.setText("");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"실패:"+ e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

        });
    }
}