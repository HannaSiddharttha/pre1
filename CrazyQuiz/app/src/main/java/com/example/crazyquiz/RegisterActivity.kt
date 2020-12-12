package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.crazyquiz.db.QuizRepository
import com.example.crazyquiz.db.Users
import com.example.crazyquiz.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {


    private lateinit var buttonregistrar2: Button
    private lateinit var buttonregresologin: Button
    private lateinit var editTextTextEmailAddress: EditText
    private lateinit var editTextTextPassword: EditText
    private lateinit var editTextTextPersonName: EditText
    private lateinit var textViewname: TextView
    private lateinit var tvemail: TextView
    private lateinit var tvpassword: TextView
    private lateinit var repository: QuizRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        repository = QuizRepository(this.application)

        val buttonregistrar2 = findViewById<Button>(R.id.buttonregistrar2)
        val buttonregresologin = findViewById<Button>(R.id.buttonregresologin)
        val editTextTextEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val editTextTextPersonName = findViewById<EditText>(R.id. editTextTextPersonName)
        val textViewname = findViewById<TextView>(R.id.textViewname)
        val tvemail = findViewById<TextView>(R.id.tvemail)
        val tvpassword = findViewById<TextView>(R.id.tvpassword)



        buttonregresologin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        buttonregistrar2.setOnClickListener {
            /*
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            */
            var user = Users(0,editTextTextPersonName.text.toString() ,editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString(), true, false , false, false, false, false,false, "10", 3, true,3)
            repository.insertUser(user)
            Toast.makeText(
                this,
                 "Se ha registrado Correctamente",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            /*   var users = repository.getUsers()
               val observer = Observer<List<Users>> { users ->
                   if (users != null) {
                       var text = ""
                       for (user in users) {
   //                        text += contact.lastName + " " + contact.firstName + " - " + contact.phoneNumber + "\n"
                       }
   //                    contacts_textView.text = text
                   }
               }
               users.observe(this, observer)
   //            for (us in users) {
   //
   //            }*/
            Log.d("TAG", "hola")


        }
    }

}