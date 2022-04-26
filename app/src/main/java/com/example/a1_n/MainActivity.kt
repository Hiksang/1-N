package com.example.a1_n

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_a.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("msg", tv_title.text.toString())
            startActivity(intent)
            finish()
        }
    }
}