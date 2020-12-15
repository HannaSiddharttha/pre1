package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.crazyquiz.db.Game
import com.example.crazyquiz.db.GameWithSelectedQuestions
import com.example.crazyquiz.db.QuizRepository
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_final_score.*
import kotlinx.android.synthetic.main.activity_final_score.view.*

class FinalScoreActivity : AppCompatActivity() {

    private lateinit var idpuntos: TextView
    private lateinit var idMenuPrincipal: Button
    private lateinit var gatoView: TextView
    private lateinit var repository: QuizRepository
    private  lateinit var p_alta_1: TextView
    private  lateinit var p_alta_2: TextView
    private  lateinit var p_alta_3: TextView
    private  lateinit var p_alta_4: TextView
    private  lateinit var p_alta_5: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)
        ModelPreferencesManager.with(this.application)
        repository = QuizRepository(this.application) //hace referencia al repositorio de la bd
        idpuntos = findViewById(R.id. idPuntos)
        idMenuPrincipal = findViewById(R.id.idMenuPrincipal)
        p_alta_1 = findViewById(R.id.P_alta_1)
        p_alta_2 = findViewById(R.id.P_alta_2)
        p_alta_3 = findViewById(R.id.P_alta_3)
        p_alta_4 = findViewById(R.id.P_alta_4)
        p_alta_5 = findViewById(R.id.P_alta_5)

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

    fun TopFive() {  //Saca el top 5 de los jugadores

        var top = repository.getTopFive()

        val topObserver = Observer<List<GameWithSelectedQuestions>> { games ->
            for(game in games) {
            // se agregan elementos a cada Textview

            //en caso de que se usó pistas se pone visible*
            }
        }
        top.observe(this, topObserver)

    }
}