package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_options.*

class OptionsActivity : AppCompatActivity() {

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
    private var settings: Settings? = null
    private var adapter1: ArrayAdapter<String>? = null
    private var adapter2: ArrayAdapter<String>? = null

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
        button_apply.setOnClickListener{  View ->

        }
        checkBox_todos.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this,
                    "Encendido",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Apagado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        checkBox_hp.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this,
                    "Encendido",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Apagado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        checkBox_gatosyreptiles.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this,
                    "Encendido",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Apagado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        checkBox_culturageneral.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this,
                    "Encendido",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Apagado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        checkBox_comida.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this,
                    "Encendido",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Apagado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        checkBox_terror.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this,
                    "Encendido",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Apagado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        checkBox_arteygeografia.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this,
                    "Encendido",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Apagado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        var spinner_info = arrayOf("5","6","7", "8", "9","10")
        adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinner_info)
        spinner_numpreguntas.adapter = adapter1


        var spinner_info2 = arrayOf("1","2", "3")
        adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinner_info2)
        spinner_pistas.adapter = adapter2

        radioGroup.setOnClickListener{  View ->
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        radioButton_alta.setOnClickListener{  View ->
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        radioButton_media.setOnClickListener{  View ->
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        radioButton_baja.setOnClickListener{  View ->
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        switch_pistas.setOnClickListener{  View ->
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        settings = Settings(true, false, false, false, false, false, false, "6", 2, false, "2")
        loadSettings()
    }

    fun loadSettings() {
        checkBox_todos.isChecked = settings?.allThemes ?: false
        checkBox_hp.isChecked = settings?.harryPotter ?: false
        checkBox_gatosyreptiles.isChecked = settings?.catReptiles ?: false
        checkBox_culturageneral.isChecked = settings?.culturaGen?: false
        checkBox_comida.isChecked = settings?.food ?: false
        checkBox_terror.isChecked = settings?.terror ?: false
        checkBox_arteygeografia.isChecked = settings?.arteGeo ?: false
        spinner_numpreguntas.setSelection(adapter1?.getPosition(settings?.numPreguntas) ?: 1);
        spinner_pistas.setSelection(adapter2?.getPosition(settings?.numPistas) ?: 1);
    }

    fun saveSettings() {

    }
}