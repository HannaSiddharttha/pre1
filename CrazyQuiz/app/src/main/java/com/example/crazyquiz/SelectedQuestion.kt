package com.example.crazyquiz

import android.graphics.Color

data class SelectedQuestion (var answer : Int, var question: Question, var answer1: Int, var answer2: Int, var answer3: Int, var answer4: Int) {

    fun isAnswered(): Boolean {
        return answer != null && answer > 0
    }

    fun isCorrect(): Boolean {

        return answer == question.Correcta
    }



    //Cambia de color Dependiendo de la respuesta **********

   private fun AnsColor() {

       if (answer == question.Correcta) {
           var colorCorreta = question.toString()
           colorCorreta.setTextColor(Color.GREEN)
       }
       else if (answer != question.Correcta && answer!=null){
           var colorIncorrecta = question.toString()
           colorIncorrecta.setTextColor(Color.RED)
       }

   }

}

private fun String.setTextColor(red: Int) {

}




