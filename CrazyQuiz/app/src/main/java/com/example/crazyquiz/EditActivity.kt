package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

private lateinit var button_editarperfil: Button
private lateinit var button_regresar3: Button

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        button_editarperfil = findViewById(R.id.button_editarperfil)
        button_regresar3 = findViewById(R.id.button_regresar3)



        button_regresar3.setOnClickListener { View ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        button_editarperfil.setOnClickListener { View ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}