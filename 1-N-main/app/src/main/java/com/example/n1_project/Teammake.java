////https://github.com/bootpay/android/blob/main/app/src/main/java/kr/co/bootpay/android/WebAppActivity.java

package com.example.n1_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Teammake extends AppCompatActivity {
       private RecyclerView recyclerView;
       private RecyclerView.Adapter adapter;
       private RecyclerView.LayoutManager layoutManager;
       private ArrayList<User> arrayList;
       private FirebaseDatabase database;
       private DatabaseReference databaseReference;
       private Button btnCreate;

       @Override
       protected void onCreate(Bundle savedInstanceState) {


       super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_teammake);
               btnCreate = findViewById(R.id.btn_create);
               btnCreate.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                             Intent intent = new Intent(Teammake.this,option.class);
                             startActivity(intent);
                      }
               });
              recyclerView = findViewById(R.id.recyclerView); // 아디 연결
              recyclerView.setHasFixedSize(true);
              layoutManager = new LinearLayoutManager(this);
              recyclerView.setLayoutManager(layoutManager);
              arrayList = new ArrayList<>();//

              database = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스 연동

              databaseReference = database.getReference("User"); // DB 테이블 연결
              databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //파이어베이스 데이터베이스의 데이터를 받아오는곳
                            arrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {// 반복문으로 데이터를 List를 추출해냄
                                   User user = snapshot.getValue(User.class);// 만들어뒀던 User 객체에 데이터를 담는다
                                   arrayList.add(user);

                            }
                            adapter.notifyDataSetChanged();
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {
                            //디비를 가져오던중 에러 발생시
                            Log.e("Teammake",String.valueOf(databaseError.toException()));//에러문출력

                     }
              });
              adapter = new CustomAdapter(arrayList, this);
              recyclerView.setAdapter(adapter);
       }
}