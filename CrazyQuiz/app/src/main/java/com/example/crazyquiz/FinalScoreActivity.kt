package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalScoreActivity : AppCompatActivity() {

    private lateinit var idpuntos: TextView
    private lateinit var idMenuPrincipal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)

        idpuntos = findViewById(R.id. idPuntos)
        idMenuPrincipal = findViewById(R.id.idMenuPrincipal)

        val intent = this.intent
        var porcentaje : Int = intent.getIntExtra("Porcentaje", 0)
        idpuntos.setText("${porcentaje}%")

        idMenuPrincipal.setOnClickListener{  View ->
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}