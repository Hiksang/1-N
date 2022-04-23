package com.example.a1_n

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) { //액티비티의 실행 시작지점
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val profileList = arrayListOf(
            Profiles(R.drawable.cflogo1, "24시 고래성", 1000, "20분소요예상"),
            Profiles(R.drawable.cflogo2, "위례달인각", 1000, "1시간소요예상"),
            Profiles(R.drawable.cflogo3, "24시승현", 10000, "30분"),
            Profiles(R.drawable.cflogo4, "보배반점", 1000, "시간")
        )

        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_profile.setHasFixedSize(true)
        rv_profile.adapter = ProfileAdapter(profileList)

        }
    }



