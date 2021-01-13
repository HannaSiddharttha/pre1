package com.example.crazyquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crazyquiz.R.drawable.*
import com.example.crazyquiz.db.Users
import com.example.crazyquiz.firebaseModels.Tablero
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_memorama.*

class MemoramaActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var myRef: DatabaseReference
    private lateinit var tablero: Tablero
    private lateinit var user: Users
    private lateinit var puntaje1: TextView
    private lateinit var puntaje2: TextView
    private var cardBack: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama)

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("tablero")

        cardBack = ic_baseline_local_fire_department_24

        puntaje1 = findViewById(R.id.jugador1_puntaje)
        puntaje2 = findViewById(R.id.jugador2_puntaje)

        val savedUser = ModelPreferencesManager.get<Users>("USER")
        if (savedUser != null) {
            user = savedUser
        }

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Obtener tablero
                var tableroFirebase = dataSnapshot.getValue(Tablero::class.java)
                if (tableroFirebase != null) {
                    tablero = tableroFirebase
                    var correo1 = tablero.jugador1.get("correo")
                    var correo2 = tablero.jugador1.get("correo")
                    if(tablero.estatus == 0 && (correo1!!.equals(user.userEmail) || correo2!!.equals(user.userEmail))) {
                        startGame()
                    } else {
//                        waitMessage()
                    }
                    loadGame()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }

        val postListener2 = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                var tableroFirebase = dataSnapshot.getValue(Tablero::class.java)
                if (tableroFirebase != null) {
                    tablero = tableroFirebase
                    loadGame()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }
        myRef.addListenerForSingleValueEvent(postListener)
        myRef.addValueEventListener(postListener2)

        cardView1.setOnClickListener {
            eventCasilla(tablero.casilla1, 1)
        }

        cardView2.setOnClickListener {
            eventCasilla(tablero.casilla2, 2)
        }

        cardView3.setOnClickListener {
            eventCasilla(tablero.casilla3, 3)
        }

        cardView4.setOnClickListener {
            eventCasilla(tablero.casilla4, 4)
        }

        cardView5.setOnClickListener {
            eventCasilla(tablero.casilla5, 5)
        }

        cardView6.setOnClickListener {
            eventCasilla(tablero.casilla6, 6)
        }

        cardView7.setOnClickListener {
            eventCasilla(tablero.casilla7, 7)
        }

        cardView8.setOnClickListener {
            eventCasilla(tablero.casilla8, 8)
        }

        cardView9.setOnClickListener {
            eventCasilla(tablero.casilla9, 9)
        }

        cardView10.setOnClickListener {
            eventCasilla(tablero.casilla10, 10)
        }

        cardView11.setOnClickListener {
            eventCasilla(tablero.casilla11, 11)
        }

        cardView12.setOnClickListener {
            eventCasilla(tablero.casilla12, 12)
        }

        cardView13.setOnClickListener {
            eventCasilla(tablero.casilla13, 13)
        }

        cardView14.setOnClickListener {
            eventCasilla(tablero.casilla14, 14)
        }

        cardView15.setOnClickListener {
            eventCasilla(tablero.casilla15, 15)
        }

        cardView16.setOnClickListener {
            eventCasilla(tablero.casilla16, 16)
        }
    }

    fun itsYourTurn(): Boolean {
        var correo1 = tablero.jugador1.get("correo").toString()
        var correo2 = tablero.jugador1.get("correo").toString()
        var correo = user.userEmail
        return (tablero.turno == 1 && correo1.equals(correo)) || (tablero.turno == 2 && correo2.equals(correo))
    }

    fun cantClick() {
        Toast.makeText( this,
            "No puedes dar click aquí",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun eventCasilla(casilla: MutableMap<String, Any>, numero: Int) {

        var casillaStatus : Long = casilla.get("estatus") as Long
        if(itsYourTurn()) {
            if(casillaStatus.toInt() == 0) {
                casillaStatus = 1
                when (numero) {
                    1 -> tablero.casilla1.set("estatus", casillaStatus)
                    2 -> tablero.casilla2.set("estatus", casillaStatus)
                    3 -> tablero.casilla3.set("estatus", casillaStatus)
                    4 -> tablero.casilla4.set("estatus", casillaStatus)
                    5 -> tablero.casilla5.set("estatus", casillaStatus)
                    6 -> tablero.casilla6.set("estatus", casillaStatus)
                    7 -> tablero.casilla7.set("estatus", casillaStatus)
                    8 -> tablero.casilla8.set("estatus", casillaStatus)
                    9 -> tablero.casilla9.set("estatus", casillaStatus)
                    10 -> tablero.casilla10.set("estatus", casillaStatus)
                    11 -> tablero.casilla11.set("estatus", casillaStatus)
                    12 -> tablero.casilla12.set("estatus", casillaStatus)
                    13 -> tablero.casilla13.set("estatus", casillaStatus)
                    14 -> tablero.casilla14.set("estatus", casillaStatus)
                    15 -> tablero.casilla15.set("estatus", casillaStatus)
                    16 -> tablero.casilla16.set("estatus", casillaStatus)
                }
                //tablero.casilla10.set("estatus", casilla10status)
                saveTablero()
            }
        } else {
            cantClick()
        }
    }

    fun saveTablero() {
        myRef.setValue(tablero)
    }

    fun startGame() {
        val images: MutableList<Int> = mutableListOf(
            gatocool,
            gatocool,
            gatoduren,
            gatoduren,
            gatoincomodo,
            gatoincomodo,
            gatokhe,
            gatokhe,
            gatolopuseaqui,
            gatolopuseaqui,
            gatobatma,
            gatobatma,
            gatosospechozo,
            gatosospechozo,
            gatotrabajando,
            gatotrabajando
        )

        images.shuffle()

        val defaultStatus: Long = 0

        tablero.casilla1.put("estatus", defaultStatus)
        tablero.casilla1.put("imagen",getResources().getResourceEntryName(images[0]))
        tablero.casilla1.put("puntoPara", defaultStatus)
        tablero.casilla2.put("estatus",defaultStatus)
        tablero.casilla2.put("imagen",getResources().getResourceEntryName(images[1]))
        tablero.casilla2.put("puntoPara", defaultStatus)
        tablero.casilla3.put("estatus",defaultStatus)
        tablero.casilla3.put("imagen",getResources().getResourceEntryName(images[2]))
        tablero.casilla3.put("puntoPara", defaultStatus)
        tablero.casilla4.put("estatus",defaultStatus)
        tablero.casilla4.put("imagen",getResources().getResourceEntryName(images[3]))
        tablero.casilla4.put("puntoPara", defaultStatus)
        tablero.casilla5.put("estatus",defaultStatus)
        tablero.casilla5.put("imagen",getResources().getResourceEntryName(images[4]))
        tablero.casilla5.put("puntoPara", defaultStatus)
        tablero.casilla6.put("estatus",defaultStatus)
        tablero.casilla6.put("imagen",getResources().getResourceEntryName(images[5]))
        tablero.casilla6.put("puntoPara", defaultStatus)
        tablero.casilla7.put("estatus",defaultStatus)
        tablero.casilla7.put("imagen",getResources().getResourceEntryName(images[6]))
        tablero.casilla7.put("puntoPara", defaultStatus)
        tablero.casilla8.put("estatus",defaultStatus)
        tablero.casilla8.put("imagen",getResources().getResourceEntryName(images[7]))
        tablero.casilla8.put("puntoPara", defaultStatus)
        tablero.casilla9.put("estatus",defaultStatus)
        tablero.casilla9.put("imagen",getResources().getResourceEntryName(images[8]))
        tablero.casilla9.put("puntoPara", defaultStatus)
        tablero.casilla10.put("estatus",defaultStatus)
        tablero.casilla10.put("imagen",getResources().getResourceEntryName(images[9]))
        tablero.casilla10.put("puntoPara", defaultStatus)
        tablero.casilla11.put("estatus",defaultStatus)
        tablero.casilla11.put("imagen",getResources().getResourceEntryName(images[10]))
        tablero.casilla11.put("puntoPara", defaultStatus)
        tablero.casilla12.put("estatus",defaultStatus)
        tablero.casilla12.put("imagen",getResources().getResourceEntryName(images[11]))
        tablero.casilla12.put("puntoPara", defaultStatus)
        tablero.casilla13.put("estatus",defaultStatus)
        tablero.casilla13.put("imagen",getResources().getResourceEntryName(images[12]))
        tablero.casilla13.put("puntoPara", defaultStatus)
        tablero.casilla14.put("estatus",defaultStatus)
        tablero.casilla14.put("imagen",getResources().getResourceEntryName(images[13]))
        tablero.casilla14.put("puntoPara", defaultStatus)
        tablero.casilla15.put("estatus",defaultStatus)
        tablero.casilla15.put("imagen",getResources().getResourceEntryName(images[14]))
        tablero.casilla15.put("puntoPara", defaultStatus)
        tablero.casilla16.put("estatus",defaultStatus)
        tablero.casilla16.put("imagen",getResources().getResourceEntryName(images[15]))
        tablero.casilla16.put("puntoPara", defaultStatus)
        saveTablero()
    }

    fun loadGame() {
        puntaje1.text = tablero.puntos1.toString()
        puntaje2.text = tablero.puntos2.toString()

        var casilla1status : Long = tablero.casilla1.get("estatus") as Long
        var casilla2status : Long = tablero.casilla2.get("estatus") as Long
        var casilla3status : Long = tablero.casilla3.get("estatus") as Long
        var casilla4status : Long = tablero.casilla4.get("estatus") as Long
        var casilla5status : Long = tablero.casilla5.get("estatus") as Long
        var casilla6status : Long = tablero.casilla6.get("estatus") as Long
        var casilla7status : Long = tablero.casilla7.get("estatus") as Long
        var casilla8status : Long = tablero.casilla8.get("estatus") as Long
        var casilla9status : Long = tablero.casilla9.get("estatus") as Long
        var casilla10status : Long = tablero.casilla10.get("estatus") as Long
        var casilla11status : Long = tablero.casilla11.get("estatus") as Long
        var casilla12status : Long = tablero.casilla12.get("estatus") as Long
        var casilla13status : Long = tablero.casilla13.get("estatus") as Long
        var casilla14status : Long = tablero.casilla14.get("estatus") as Long
        var casilla15status : Long = tablero.casilla15.get("estatus") as Long
        var casilla16status : Long = tablero.casilla16.get("estatus") as Long

        if(casilla1status.toInt() == 0) {
            imageView1.setImageResource(cardBack)
        } else {
            val id1 = getResources().getIdentifier(tablero.casilla1.get("imagen").toString(), "drawable", getPackageName())
            imageView1.setImageResource(id1)
        }

        if(casilla2status.toInt() == 0) {
            imageView2.setImageResource(cardBack)
        } else {
            val id2 = getResources().getIdentifier(tablero.casilla2.get("imagen").toString(), "drawable", getPackageName())
            imageView2.setImageResource(id2)
        }

        if(casilla3status.toInt() == 0) {
            imageView3.setImageResource(cardBack)
        } else {
            val id3 = getResources().getIdentifier(tablero.casilla3.get("imagen").toString(), "drawable", getPackageName())
            imageView3.setImageResource(id3)
        }

        if(casilla4status.toInt() == 0) {
            imageView4.setImageResource(cardBack)
        } else {
            val id4 = getResources().getIdentifier(tablero.casilla4.get("imagen").toString(), "drawable", getPackageName())
            imageView4.setImageResource(id4)
        }

        if(casilla5status.toInt() == 0) {
            imageView5.setImageResource(cardBack)
        } else {
            val id5 = getResources().getIdentifier(tablero.casilla5.get("imagen").toString(), "drawable", getPackageName())
            imageView5.setImageResource(id5)
        }

        if(casilla6status.toInt() == 0) {
            imageView6.setImageResource(cardBack)
        } else {
            val id6 = getResources().getIdentifier(tablero.casilla6.get("imagen").toString(), "drawable", getPackageName())
            imageView6.setImageResource(id6)
        }

        if(casilla7status.toInt() == 0) {
            imageView7.setImageResource(cardBack)
        } else {
            val id7 = getResources().getIdentifier(tablero.casilla7.get("imagen").toString(), "drawable", getPackageName())
            imageView7.setImageResource(id7)
        }

        if(casilla8status.toInt() == 0) {
            imageView8.setImageResource(cardBack)
        } else {
            val id8 = getResources().getIdentifier(tablero.casilla8.get("imagen").toString(), "drawable", getPackageName())
            imageView8.setImageResource(id8)
        }

        if(casilla9status.toInt() == 0) {
            imageView9.setImageResource(cardBack)
        } else {
            val id9 = getResources().getIdentifier(tablero.casilla9.get("imagen").toString(), "drawable", getPackageName())
            imageView9.setImageResource(id9)
        }

        if(casilla10status.toInt() == 0) {
            imageView10.setImageResource(cardBack)
        } else {
            val id10 = getResources().getIdentifier(tablero.casilla10.get("imagen").toString(), "drawable", getPackageName())
            imageView10.setImageResource(id10)
        }

        if(casilla11status.toInt() == 0) {
            imageView11.setImageResource(cardBack)
        } else {
            val id11 = getResources().getIdentifier(tablero.casilla11.get("imagen").toString(), "drawable", getPackageName())
            imageView11.setImageResource(id11)
        }

        if(casilla12status.toInt() == 0) {
            imageView12.setImageResource(cardBack)
        } else {
            val id12 = getResources().getIdentifier(tablero.casilla12.get("imagen").toString(), "drawable", getPackageName())
            imageView12.setImageResource(id12)
        }

        if(casilla13status.toInt() == 0) {
            imageView13.setImageResource(cardBack)
        } else {
            val id13 = getResources().getIdentifier(tablero.casilla13.get("imagen").toString(), "drawable", getPackageName())
            imageView13.setImageResource(id13)
        }

        if(casilla14status.toInt() == 0) {
            imageView14.setImageResource(cardBack)
        } else {
            val id14 = getResources().getIdentifier(tablero.casilla14.get("imagen").toString(), "drawable", getPackageName())
            imageView14.setImageResource(id14)
        }

        if(casilla15status.toInt() == 0) {
            imageView15.setImageResource(cardBack)
        } else {
            val id15 = getResources().getIdentifier(tablero.casilla15.get("imagen").toString(), "drawable", getPackageName())
            imageView15.setImageResource(id15)
        }

        if(casilla16status.toInt() == 0) {
            imageView16.setImageResource(cardBack)
        } else {
            val id16 = getResources().getIdentifier(tablero.casilla16.get("imagen").toString(), "drawable", getPackageName())
            imageView16.setImageResource(id16)
        }
    }
}