package com.example.crazyquiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.viewModels
import androidx.core.graphics.toColorInt
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_question.*
import kotlin.math.roundToInt

class QuestionActivity : AppCompatActivity() {

    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var preguntaTextView: TextView
    private lateinit var numPreguntaTextView: TextView
    private lateinit var Opcion1: Button
    private lateinit var Opcion2: Button
    private lateinit var Opcion3: Button
    private lateinit var Opcion4: Button
    private lateinit var AnswerCorrect: Button
    private lateinit var PuntuacionTotal: TextView
    private lateinit var numPistas: Button

    private val model: GameModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        ModelPreferencesManager.with(this.application)

        prevButton = findViewById(R.id.prev_button)
        nextButton = findViewById(R.id.next_button)
        preguntaTextView = findViewById(R.id.preguntaTextView)
        numPreguntaTextView = findViewById(R.id.idNumPreguntas)
        Opcion1 = findViewById(R.id.btnOpcion1)
        Opcion2 = findViewById(R.id.btnOpcion2)
        Opcion3 = findViewById(R.id.btnOpcion3)
        Opcion4 = findViewById(R.id.btnOpcion4)
        PuntuacionTotal = findViewById(R.id.PuntuacionTextView) // <- score Total
        numPistas = findViewById(R.id.btnPistas)

        // obtiene los settings, si los encuentra los asigna a settings.
        val savedSettings = ModelPreferencesManager.get<Settings>("SETTINGS")
        if(savedSettings != null) {
            model.settings = savedSettings
        }
        model.filterQuestions()

        // ocultar opciones dependiendo de dificultad

        // dificultad media - ocultar ultima pregunta
        if(model.settings.dificultad == 2) {
            Opcion4.setVisibility(View.GONE)
        }

        // dificultad baja - ocultar ultimas 2 preguntas
        if(model.settings.dificultad == 1) {
            Opcion3.setVisibility(View.GONE)
            Opcion4.setVisibility(View.GONE)
        }

        if(!model.settings.habilitarPistas) {
            numPistas.setVisibility(View.INVISIBLE)
        } else {
            numPistas.setText("Pistas: ${model.settings.numPistas}")
        }

        // se pone la primera pregunta
        loadQuestion()

        prevButton.setOnClickListener { view: View ->
            model.prevQuestion()
            loadQuestion()
        }
        nextButton.setOnClickListener { view: View ->
            model.nextQuestion()
            loadQuestion()
        }
        numPistas.setOnClickListener { view: View ->
            // si no esta respondida, te quedan pistas y hay al menos 2 botones sin bloquear continúa
            if(!model.currentQuestion.isAnswered() && model.settings.numPistas > 0 && model.notLockedButtons() >= 2) {
                model.settings.numPistas--
                model.blockButton()
                loadQuestion()
                numPistas.setText("Pistas: ${model.settings.numPistas}")
            }
        }

        //Opción1 ---
        Opcion1.setOnClickListener { view: View ->
            optionEvent(model.currentQuestion.answer1)
        }
        Opcion2.setOnClickListener { view: View ->
            optionEvent(model.currentQuestion.answer2)
        }
        Opcion3.setOnClickListener { view: View ->
            optionEvent(model.currentQuestion.answer3)
        }
        Opcion4.setOnClickListener { view: View ->
            optionEvent(model.currentQuestion.answer4)
        }
    }

    fun optionEvent(selectedOption : Int) {
        if (model.currentQuestion.isAnswered()) {
            Toast.makeText(
                this,
                if (model.currentQuestion.isCorrect()) "Ya has contestado correctamente"
                else "Ya has contestado incorrectamente",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // se selecciono la opcion
            model.currentQuestion.answer = selectedOption

            // mensaje si la respuesta fue correcta o no
            val result = if (model.currentQuestion.isCorrect()) "correcto" else "incorrecto"
            Toast.makeText(
                this,
                result,
                Toast.LENGTH_SHORT
            ).show()

            //si es correcta suma puntaje
            if(model.currentQuestion.isCorrect()) {
                model.puntuacion_actual++
            }


            if(model.gameFinished()) {
                // PuntuacionTotal.text = "Final: ${(model.numberOfGoodAnswers.toFloat() / (model.questionsSize).toFloat()) * 100} pts"
                var maxPuntos = model.selectedQuestions.size * model.settings.dificultad
                var totalPuntos = model.totalPuntos()
                var porcentaje : Int = (((totalPuntos.toFloat()/maxPuntos.toFloat()).toFloat())*100).roundToInt()
                PuntuacionTotal.text = "final: ${totalPuntos} pts ${porcentaje}%"


                    val intent = Intent(this, FinalScoreActivity::class.java)
                    intent.putExtra("Porcentaje", porcentaje)
                    startActivity(intent)
            } else {
                PuntuacionTotal.text = "${model.totalPuntos()} pts"
            }

            if (model.puntuacion_actual == model.questionsSize) {
                Toast.makeText(
                    this,
                    "Game Over",
                    Toast.LENGTH_SHORT
                ).show()
            }
            AnsColor()
        }
    }

    fun loadQuestion() {
        preguntaTextView.setText(model.currentQuestion.question.strRestId)
        numPreguntaTextView.setText("${model.currentQuestionNumber}/${model.questionsSize}")
        Opcion1.setText(model.currentQuestion.answer1)
        Opcion2.setText(model.currentQuestion.answer2)
        if(model.settings.dificultad >= 2) {
            Opcion3.setText(model.currentQuestion.answer3)
        }
        if(model.settings.dificultad == 3) {
            Opcion4.setText(model.currentQuestion.answer4)
        }
        AnsColor()
    }

    //Cambia de color Dependiendo de la respuesta  *
    fun AnsColor() {
        var green : Int = Color.parseColor("#008F39")
        var red : Int = Color.parseColor("#FF0000")
        var white : Int = Color.parseColor("#FFFFFF")
        var gray : Int = Color.parseColor("#616161")

        Opcion1.setTextColor(white)
        Opcion2.setTextColor(white)
        Opcion3.setTextColor(white)
        Opcion4.setTextColor(white)

        if(model.currentQuestion.answer1Locked) {
            Opcion1.setTextColor(gray)
            Opcion1.setEnabled(false)
        } else {
            Opcion1.setEnabled(true)
        }

        if(model.currentQuestion.answer2Locked) {
            Opcion2.setTextColor(gray)
            Opcion2.setEnabled(false)
        } else {
            Opcion2.setEnabled(true)
        }

        if(model.currentQuestion.answer3Locked) {
            Opcion3.setTextColor(gray)
            Opcion3.setEnabled(false)
        } else {
            Opcion3.setEnabled(true)
        }

        if(model.currentQuestion.answer4Locked) {
            Opcion4.setTextColor(gray)
            Opcion4.setEnabled(false)
        } else {
            Opcion4.setEnabled(true)
        }

        if (model.currentQuestion.isAnswered()) {
            if(model.currentQuestion.answer == model.currentQuestion.answer1) {
                if (model.currentQuestion.isCorrect()) {
                    Opcion1.setTextColor(green) // verde
                } else {
                    Opcion1.setTextColor(red) // rojo
                }
            }
            if(model.currentQuestion.answer == model.currentQuestion.answer2) {
                if (model.currentQuestion.isCorrect()) {
                    Opcion2.setTextColor(green) // verde
                } else {
                    Opcion2.setTextColor(red) // rojo
                }
            }
            if(model.currentQuestion.answer == model.currentQuestion.answer3) {
                if (model.currentQuestion.isCorrect()) {
                    Opcion3.setTextColor(green) // verde
                } else {
                    Opcion3.setTextColor(red) // rojo
                }
            }
            if(model.currentQuestion.answer == model.currentQuestion.answer4) {
                if (model.currentQuestion.isCorrect()) {
                    Opcion4.setTextColor(green) // verde
                } else {
                    Opcion4.setTextColor(red) // rojo
                }
            }
        }
    }
}