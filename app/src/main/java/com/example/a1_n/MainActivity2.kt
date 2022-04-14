package com.example.a1_n

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.cflogo1, "24시 고래성","1000","1000"),
        User(R.drawable.cflogo2, "위례달인각","1000","1000"),
        User(R.drawable.cflogo3, "24시승현","1000","1000"),
        User(R.drawable.cflogo4, "보배반점","1000","10000"),

        )
    override fun onCreate(savedInstanceState: Bundle?) { //액티비티의 실행 시작지점
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//        val item = arrayOf("사과","배","딸기","키위")
//        // context란 한 액티비티의 모든 정보를 읽고있다
//        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
        val Adapter = UserAdapter(this,UserList)
        listView.adapter = Adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this,selectItem.name, Toast.LENGTH_SHORT).show()//현재 클릭한 포지션 변수생성
        }

    }
}