package com.example.n1_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class chamga extends AppCompatActivity {
    private Intent intent44;
    String tv_tm2;
    String tv_lc2;
    String tv_rn2;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    private Button btnAdd2, btnMinus2,addbtn2;
    private TextView tvCount2;
    private int count=0;
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
    ;

        tvCount2 = findViewById(R.id.tv_count2);
        tvCount2.setText(count*6000+1000+"");
        btnAdd2 = findViewById(R.id.btn_add2);
        btnMinus2 = findViewById(R.id.btn_minus2);
        addbtn2 = findViewById(R.id.add_btn2);

        btnAdd2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count++;
                tvCount2.setText(count*6000+1000+"");
            }
        });

        btnMinus2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count--;
                tvCount2.setText(count*6000+1000+"");
            }
        });
        addbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //입력값 변수 담기
                addMenu(tvCount2.getText().toString());

            }
        });
    }

    public void addMenu(String menu2) {
        menu3 menu44 = new menu3(menu2);

        databaseReference.child("User").child("Team_01").push().setValue(menu44);
    }
    public void goNativeActivity(View v) {
        String price4 = tvCount2.getText().toString();
        Intent intent = new Intent(getApplicationContext(), NativeActivity.class);
        intent.putExtra("price1",price4);
        startActivity(intent);

    }


}
