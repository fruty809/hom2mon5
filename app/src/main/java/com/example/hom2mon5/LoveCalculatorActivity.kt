package com.example.hom2mon5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoveCalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love_calculator)

        // Set up button click listener
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            // Get the input values
            val person1Name = findViewById<EditText>(R.id.editTextPerson1).text.toString().trim()
            val person2Name = findViewById<EditText>(R.id.editTextPerson2).text.toString().trim()

            // Calculate love score
            val loveScore = calculateLoveScore(person1Name, person2Name)

            // Start com.example.hom2mon5.ResultActivity with the love score and input names
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("person1Name", person1Name)
            intent.putExtra("person2Name", person2Name)
            intent.putExtra("loveScore", loveScore)
            startActivity(intent)
        }
    }

    private fun calculateLoveScore(person1Name: String, person2Name: String): Int {
        // TODO: Implement love score calculation
        return 50 // default value
    }
}
