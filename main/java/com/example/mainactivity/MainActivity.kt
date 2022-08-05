package com.example.mainactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

data class Journals(var todayText: String, var diffcText: String, var planText: String){
    companion object {
        fun saveToPreference(
            pref: SharedPreferences,
            todayText: String,
            diffcText: String,
            planText: String) : Journals {
            val editor = pref.edit()

            editor.putString("todayText",todayText)
            editor.putString("diffcText",diffcText)
            editor.putString("planText",planText)

            editor.apply()

            return Journals(todayText, diffcText, planText)
        }

        fun getJournalsFromPreference(pref: SharedPreferences) : MutableList<Journals> {
            val journals = mutableListOf<Journals>()

            for(i in 0 until 20) {
                val today = pref.getString("${i}.today","")!!
                val diffc = pref.getString("${i}.diffc","")!!
                val plan = pref.getString("${i}.plan","")!!
                if(today.isNotBlank()) {
                    journals.add(Journals(today, diffc, plan))
                }
            }
            return journals
        }
    }
}

class MainActivity : AppCompatActivity() {

    private lateinit var journals: MutableList<Journals>
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //상단 제목 표시줄 숨기기
        supportActionBar?.hide()

        pref = getSharedPreferences("journals", Context.MODE_PRIVATE)
        journals = Journals.getJournalsFromPreference(pref)

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