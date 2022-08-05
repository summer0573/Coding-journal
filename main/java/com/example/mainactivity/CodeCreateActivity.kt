package com.example.mainactivity


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class CodeCreateActivity(val dataList: List<Journals>)
    :RecyclerView.Adapter<CodeCreateActivity.journalsItemViewHolder>()
{
    class journalsItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        lateinit var journal : Journals
        val todayCode = view.findViewById<EditText>(R.id.today_code)
        val diffcText = view.findViewById<EditText>(R.id.diffc_text)
        val planText = view.findViewById<EditText>(R.id.plan_text)
        val writeBtn = view.findViewById<Button>(R.id.write_code)

        init {

            val pref = view.context.getSharedPreferences("journals", Context.MODE_PRIVATE)

            writeBtn.setOnClickListener{
                Toast.makeText(it.context,"작성되었습니다.", Toast.LENGTH_SHORT).show()
                val newToday = todayCode.text.toString()
                val newDiffic = diffcText.text.toString()
                val newPlan = planText.text.toString()

                Journals.saveToPreference(pref, newToday, newDiffic, newPlan)
            }
        }

        fun bind(jou: Journals) {
            journal = jou

            todayCode.setText(journal.todayText)
            diffcText.setText(journal.diffcText)
            planText.setText(journal.planText)

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): journalsItemViewHolder {
        Log.d("mytag", "onCreateViewHolder")
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)

        return CodeCreateActivity.journalsItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: journalsItemViewHolder, position: Int) {
        Log.d("mytag", position.toString())
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.create_activity)
//
//        //상단 제목 표시줄 숨기기
//        supportActionBar?.hide()
//    }
