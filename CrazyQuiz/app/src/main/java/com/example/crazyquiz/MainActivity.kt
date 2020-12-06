package com.example.crazyquiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.facebook.stetho.Stetho


class MainActivity : AppCompatActivity() {

    private lateinit var button_juego: Button
    private lateinit var button_options: Button

    private val model: GameModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Base de datos ??
        Stetho.initializeWithDefaults(this)


        button_juego = findViewById(R.id. button_juego)
        button_options = findViewById(R.id. button_options)

        button_options.setOnClickListener{  View ->
            val intent = Intent(this,OptionsActivity::class.java)
            startActivity(intent)
        }
        button_juego.setOnClickListener{  View ->
            val intent = Intent(this,QuestionActivity::class.java)
            startActivity(intent)
        }




        }


    }

