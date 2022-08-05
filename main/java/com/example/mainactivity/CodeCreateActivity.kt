package com.example.mainactivity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CodeCreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_activity)

        //val pref = getSharedPreferences("journals", Context.MODE_PRIVATE)
        //val journals = Journals.getJournalsFromPreference(pref)

        val editJournals = mutableListOf<Journals>()
        for(i in 0 until 20) {
            editJournals.add(Journals("", "", ""))
        }

        val layoutManager = LinearLayoutManager(this)
        val adapter = CodeCreateAdapter(editJournals)

        val listView = findViewById<RecyclerView>(R.id.create_adapter)
        listView.setHasFixedSize(false)
        listView.layoutManager = layoutManager
        listView.adapter = adapter

    }
}