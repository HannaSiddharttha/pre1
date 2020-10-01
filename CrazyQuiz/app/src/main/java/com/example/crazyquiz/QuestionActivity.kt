package com.example.crazyquiz

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
import kotlinx.android.synthetic.main.activity_question.*


class QuestionActivity : AppCompatActivity() {


    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var preguntaTextView: TextView
    private lateinit var Opcion1: Button
    private lateinit var Opcion2: Button
    private lateinit var Opcion3: Button
    private lateinit var Opcion4: Button
    private lateinit var AnswerCorrect: Button
    private lateinit var PuntuacionTotal : TextView

    private val model: GameModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        prevButton = findViewById(R.id.prev_button)
        nextButton = findViewById(R.id.next_button)
        preguntaTextView = findViewById(R.id.preguntaTextView)
        Opcion1 = findViewById(R.id.btnOpcion1)
        Opcion2 = findViewById(R.id.btnOpcion2)
        Opcion3 = findViewById(R.id.btnOpcion3)
        Opcion4 = findViewById(R.id.btnOpcion4)
        AnswerCorrect = findViewById(R.id.btnOpcion1) // <- la opcion 1 siempre es la correcta
        PuntuacionTotal = findViewById(R.id.PuntuacionTextView) // <- score Total

        //se pasa la pregunta al Textview de preguntas
        preguntaTextView.setText(model.currentQuestion.toString())


        //Opción1 ---
        Opcion1.setOnClickListener { view: View ->
            if (model.currentQuestion.isAnswered()) {
                Toast.makeText(
                    this,
                    if (model.currentQuestion.isCorrect()) "Ya has contestado  correctamente"
                    else "Ya has contestado incorrectamente",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                model.puntuacion_actual ++
                if (!model.currentQuestion.answer) {
                    model.numberOfGoodAnswers++
                    model.currentQuestion.isCorrect() = true
                }
                if (model.puntuacion_actual == model.TotalQuestions) {
                    PuntuacionTotal.text = "Score: ${(model.numberOfGoodAnswers.toFloat()/(model.TotalQuestions).toFloat())*100} puntos"
                } else {
                    PuntuacionTotal.text = "${model.puntuacion_actual}/${model.TotalQuestions}"
                }
                model.currentQuestion.isCorrect() = true
                val result = if (!model.currentQuestion.isCorrect()) "correcto" else "incorrecto"

                Toast.makeText(
                    this,
                    result,
                    Toast.LENGTH_SHORT
                ).show()
                if (model.puntuacion_actual == model.TotalQuestions){
                    Toast.makeText(
                        this,
                        "Game Over",
                        Toast.LENGTH_SHORT).show()

                }

            }
        }





        //Cambia de color Dependiendo de la respuesta  *

        private fun AnsColor() {

            // cambia a verde
            if (AnswerCorrect == model.selectedQuestions.Correcta) {
                Opcion1.setTextColor(Color.parseColor("008F39"))
            }

            // cmabia a rojo
            else if (AnswerCorrect !== model.selectedQuestions.Correcta && AnswerCorrect != null) {
                Opcion1.setTextColor(Color.parseColor("FF0000"))
            }

        }


    }