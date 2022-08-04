package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //상단 제목 표시줄 숨기기
        supportActionBar?.hide()


        val createBtn = findViewById<Button>(R.id.create_code_btn)
        createBtn.setOnClickListener{
            val intent = Intent(this, CodeCreateActivity::class.java)
            startActivity(intent)
        }

//        val deleteBtn = findViewById<Button>(R.id.delete_code_btn)
//        deleteBtn.setOnClickListener{
//            val intent = Intent(this, CodeDeleteActivity::class.java)
//            startActivity(intent)
//        }
    }
}