package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class CodeCreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_create)

        val writeBtn = findViewById<Button>(R.id.write_btn)
        writeBtn.setOnClickListener{
            Log.d("mytag", "작성하기")
        }
    }
}