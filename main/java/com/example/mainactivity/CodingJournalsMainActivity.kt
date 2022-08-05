package com.example.mainactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class CodingJournalsMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //상단 제목 표시줄 숨기기
        supportActionBar?.hide()

        val createBtn = findViewById<Button>(R.id.create_code_btn)
        createBtn.setOnClickListener{
            Log.d("mytag", "작성하기 버튼")
            val intent = Intent(this, CodeCreateActivity::class.java)
            startActivity(intent)
        }

        val deleteBtn = findViewById<Button>(R.id.delete_code_btn)
        Log.d("mytag", "삭제하기 버튼")
        deleteBtn.setOnClickListener{
            val intent = Intent(this, CodeDeleteActivity::class.java)
            startActivity(intent)
        }
    }
}