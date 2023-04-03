package com.example.hom2mon5

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Get the input values from the intent extras
        val person1Name = intent.getStringExtra("person1Name")
        val person2Name = intent.getStringExtra("person2Name")
        val loveScore = intent.getIntExtra("loveScore", 0)

        // Set the result text
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        textViewResult.text = getString(R.string.result_text, person1Name, person2Name, loveScore)
    }
}
