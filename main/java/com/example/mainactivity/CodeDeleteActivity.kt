package com.example.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CodeDeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.delete_activity)

        //상단 제목 표시줄 숨기기
        supportActionBar?.hide()

    }
}