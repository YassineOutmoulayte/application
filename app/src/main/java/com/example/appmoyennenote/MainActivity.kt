package com.example.appmoyennenote

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNote1 = findViewById<EditText>(R.id.note1)
        val editTextNote2 = findViewById<EditText>(R.id.note2)
        val editTextNote3 = findViewById<EditText>(R.id.note3)
        val editTextNote4 = findViewById<EditText>(R.id.note4)
        val buttonCalculate = findViewById<Button>(R.id.calculateButton)
        val textViewResult = findViewById<TextView>(R.id.resultText)

        buttonCalculate.setOnClickListener {
            val note1 = editTextNote1.text.toString().toDoubleOrNull() ?: 0.0
            val note2 = editTextNote2.text.toString().toDoubleOrNull() ?: 0.0
            val note3 = editTextNote3.text.toString().toDoubleOrNull() ?: 0.0
            val note4 = editTextNote4.text.toString().toDoubleOrNull() ?: 0.0

            val moyenne = (note1 + note2 + note3 + note4) / 4
            val message = when {
                moyenne > 16 -> "La moyenne des notes est: %.2f - Excellent".format(moyenne)
                moyenne >= 14 -> "La moyenne des notes est: %.2f - Très bien".format(moyenne)
                moyenne >= 12 -> "La moyenne des notes est: %.2f - Bien".format(moyenne)
                moyenne >= 10 -> "La moyenne des notes est: %.2f - Assez bien".format(moyenne)
                else -> "La moyenne des notes est: %.2f - Échec".format(moyenne)
            }



            textViewResult.text = "La moyenne des notes est: %.2f".format(moyenne)
            textViewResult.text = message


        }
    }
}