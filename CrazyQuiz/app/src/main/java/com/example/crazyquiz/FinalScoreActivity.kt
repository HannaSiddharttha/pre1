package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_final_score.*
import kotlinx.android.synthetic.main.activity_final_score.view.*

class FinalScoreActivity : AppCompatActivity() {

    private lateinit var idpuntos: TextView
    private lateinit var idMenuPrincipal: Button
    private lateinit var gatoView: TextView

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

        if( porcentaje == 100){
            GatoImageView.setImageResource(R.drawable.happy1)
        }
        else if(porcentaje <100 && porcentaje >= 50){
            GatoImageView.setImageResource(R.drawable.confuse1)
        }
        else if (porcentaje>=0 && porcentaje<50){
            GatoImageView.setImageResource(R.drawable.sad1)
        }




    }
}