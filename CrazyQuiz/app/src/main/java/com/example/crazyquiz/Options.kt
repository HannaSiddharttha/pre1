package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Options : AppCompatActivity() {

    private lateinit var button_return : Button
    private lateinit var button_aply : Button
    private lateinit var checkBox_todos : CheckBox
    private lateinit var checkBox_hp: CheckBox
    private lateinit var checkBox_gatosyreptiles: CheckBox
    private lateinit var checkBox_comida: CheckBox
    private lateinit var checkBox_terror: CheckBox
    private lateinit var checkBox_culturageneral: CheckBox
    private lateinit var checkBox_arteygeografia: CheckBox
    private lateinit var spinner_numpreguntas: Spinner
    private lateinit var spinner_pistas: Spinner
    private lateinit var radioGroup:RadioGroup
    private lateinit var radioButton_alta: RadioButton
    private lateinit var radioButton_media: RadioButton
    private lateinit var radioButton_baja: RadioButton
    private lateinit var switch_pistas: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        button_aply = findViewById(R.id. button_apply)
        button_return = findViewById(R.id. button_return)
        checkBox_todos = findViewById(R.id.checkBox_todos)
        checkBox_hp = findViewById(R.id.checkBox_hp)
        checkBox_gatosyreptiles = findViewById(R.id.checkBox_gatosyreptiles)
        checkBox_comida = findViewById(R.id.checkBox_comida)
        checkBox_terror = findViewById(R.id.checkBox_terror)
        checkBox_culturageneral = findViewById(R.id.checkBox_culturageneral)
        checkBox_arteygeografia = findViewById(R.id.checkBox_arteygeografia)
        spinner_numpreguntas = findViewById(R.id.spinner_numpreguntas)
        spinner_pistas = findViewById(R.id. spinner_pistas)
        radioGroup = findViewById(R.id. radioGroup)
        radioButton_alta = findViewById(R.id.radioButton_alta)
        radioButton_media = findViewById(R.id.radioButton_media)
        radioButton_baja = findViewById(R.id.radioButton_baja)
        switch_pistas = findViewById(R.id.switch_pistas)

        button_return.setOnClickListener{  View ->
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}