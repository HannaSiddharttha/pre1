package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.crazyquiz.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {


    private lateinit var buttonregistrar2: Button
    private lateinit var buttonregresologin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonregistrar2 = findViewById<Button>(R.id.buttonregistrar2)
        val buttonregresologin = findViewById<Button>(R.id.buttonregresologin)
        buttonregresologin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        buttonregistrar2.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}