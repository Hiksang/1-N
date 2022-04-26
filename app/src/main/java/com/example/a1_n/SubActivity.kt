package com.example.a1_n

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

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