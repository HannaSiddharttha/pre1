package com.example.crazyquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        // aqui se debe recibir "settings" por medio de un intent
    }
}