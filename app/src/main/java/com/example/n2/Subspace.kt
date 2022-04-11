package com.example.n2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Subspace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subspace)
        val intent = Intent(this, Team::class.java)
        val buttonView = findViewById<Button>(R.id.btn_3)
        buttonView.setOnClickListener{
            startActivity(intent)

        }
    }
}