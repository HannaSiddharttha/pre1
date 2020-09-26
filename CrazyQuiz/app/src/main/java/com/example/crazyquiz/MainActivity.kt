package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels



class MainActivity : AppCompatActivity() {

    private lateinit var button_juego: Button
    private lateinit var button_options: Button
    private lateinit var button_5act: Button

    private val model: GameModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_juego = findViewById(R.id. button_juego)
        button_options = findViewById(R.id. button_options)
        button_5act = findViewById(R.id.button_5act)

        button_options.setOnClickListener{  View ->
            val intent = Intent(this,Options::class.java)
            startActivity(intent)
        }
        button_juego.setOnClickListener{  View ->
            val intent = Intent(this,QuestionActivity::class.java)
            startActivity(intent)
        }
        button_5act.setOnClickListener{  View ->
            val intent = Intent(this,FinalScoreActivity::class.java)
            startActivity(intent)
        }
    }
}