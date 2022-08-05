package com.example.mainactivity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CodeCreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_activity)

        val pref = getSharedPreferences("journals", Context.MODE_PRIVATE)
        val journals = Journals.getJournalsFromPreference(pref)

        val editJournals = mutableListOf<Journals>()
        for(i in 0 until 20) {
            editJournals.add(Journals("", "", ""))
        }
        for(j in journals) {
            editJournals
        }

    }
}