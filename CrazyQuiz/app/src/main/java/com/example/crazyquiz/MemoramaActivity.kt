package com.example.crazyquiz

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
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
    var green : Int = Color.parseColor("#008F39")
    var red : Int = Color.parseColor("#FF0000")
    var white : Int = Color.parseColor("#FFFFFF")
    private var cardBack: Int = 0
    private lateinit var imageViews: MutableList<ImageView>
    private lateinit var cardViews: MutableList<CardView>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama)

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("tablero")

        cardBack = ic_baseline_local_fire_department_24

        puntaje1 = findViewById(R.id.jugador1_puntaje)
        puntaje2 = findViewById(R.id.jugador2_puntaje)

        imageViews = mutableListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,
            imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16)

        cardViews = mutableListOf(cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,
            cardView8,cardView9,cardView10,cardView11,cardView12,cardView13,cardView14,cardView15,cardView16)

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
        //Ganador()
    }

    fun itsYourTurn(): Boolean {
        var correo1 = tablero.jugador1.get("correo").toString()
        var correo2 = tablero.jugador2.get("correo").toString()
        var correo = user.userEmail
        return (tablero.turno == 1 && correo1.equals(correo)) || (tablero.turno == 2 && correo2.equals(correo))
    }

    fun getPlayerNumber(): Int {
        var correo1 = tablero.jugador1.get("correo").toString()
        var correo2 = tablero.jugador2.get("correo").toString()
        var correo = user.userEmail
        if(correo1.equals(correo)) {
            return 1
        }
        if(correo2.equals(correo)) {
            return 2
        }
        return 0
    }

    fun cantClick() {
        Toast.makeText( this,
            "No puedes dar click aquí",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun getStatusTableroList(): MutableList<Long>{
        val statusTablero: MutableList<Long> = mutableListOf(
            tablero.casilla1.get("estatus") as Long,
            tablero.casilla2.get("estatus") as Long,
            tablero.casilla3.get("estatus") as Long,
            tablero.casilla4.get("estatus") as Long,
            tablero.casilla5.get("estatus") as Long,
            tablero.casilla6.get("estatus") as Long,
            tablero.casilla7.get("estatus") as Long,
            tablero.casilla8.get("estatus") as Long,
            tablero.casilla9.get("estatus") as Long,
            tablero.casilla10.get("estatus") as Long,
            tablero.casilla11.get("estatus") as Long,
            tablero.casilla12.get("estatus") as Long,
            tablero.casilla13.get("estatus") as Long,
            tablero.casilla14.get("estatus") as Long,
            tablero.casilla15.get("estatus") as Long,
            tablero.casilla16.get("estatus") as Long
        )
        return statusTablero
    }

    fun getPuntosParaList(): MutableList<Long>{
        val puntosPara: MutableList<Long> = mutableListOf(
            tablero.casilla1.get("puntoPara") as Long,
            tablero.casilla2.get("puntoPara") as Long,
            tablero.casilla3.get("puntoPara") as Long,
            tablero.casilla4.get("puntoPara") as Long,
            tablero.casilla5.get("puntoPara") as Long,
            tablero.casilla6.get("puntoPara") as Long,
            tablero.casilla7.get("puntoPara") as Long,
            tablero.casilla8.get("puntoPara") as Long,
            tablero.casilla9.get("puntoPara") as Long,
            tablero.casilla10.get("puntoPara") as Long,
            tablero.casilla11.get("puntoPara") as Long,
            tablero.casilla12.get("puntoPara") as Long,
            tablero.casilla13.get("puntoPara") as Long,
            tablero.casilla14.get("puntoPara") as Long,
            tablero.casilla15.get("puntoPara") as Long,
            tablero.casilla16.get("puntoPara") as Long
        )
        return puntosPara
    }

    fun getImagenList(): MutableList<String>{
        val puntosPara: MutableList<String> = mutableListOf(
            tablero.casilla1.get("imagen") as String,
            tablero.casilla2.get("imagen") as String,
            tablero.casilla3.get("imagen") as String,
            tablero.casilla4.get("imagen") as String,
            tablero.casilla5.get("imagen") as String,
            tablero.casilla6.get("imagen") as String,
            tablero.casilla7.get("imagen") as String,
            tablero.casilla8.get("imagen") as String,
            tablero.casilla9.get("imagen") as String,
            tablero.casilla10.get("imagen") as String,
            tablero.casilla11.get("imagen") as String,
            tablero.casilla12.get("imagen") as String,
            tablero.casilla13.get("imagen") as String,
            tablero.casilla14.get("imagen") as String,
            tablero.casilla15.get("imagen") as String,
            tablero.casilla16.get("imagen") as String
        )
        return puntosPara
    }

    fun turnFinished(): Boolean {
        var clicks : Int = 0
        val statusTablero = getStatusTableroList()
        val puntosPara = getPuntosParaList()

        for(i in 0..15) {
            if(statusTablero[i].toInt() == 1 && puntosPara[i].toInt() == 0) {
                clicks++
            }
        }
        return clicks >= 2
    }

    fun gotAPoint(): Boolean {
        var clicks : Int = 0
        val statusTablero = getStatusTableroList()
        val puntosPara = getPuntosParaList()
        val images = getImagenList()
        var image1: String = ""
        var image2: String = ""

        for(i in 0..15) {
            if(statusTablero[i].toInt() == 1 && puntosPara[i].toInt() == 0) {
                clicks++
                if(clicks == 1) {
                    image1 = images[i]
                }
                if(clicks == 2) {
                    image2 = images[i]
                }
            }
        }
        return image1 == image2
    }

    fun hideCards() {
        val statusTablero = getStatusTableroList()
        val puntosPara = getPuntosParaList()
        var casillaStatus : Long = 0

        for(i in 0..15) {
            if(statusTablero[i].toInt() == 1 && puntosPara[i].toInt() == 0) {
                when (i) {
                    0 -> tablero.casilla1.set("estatus", casillaStatus)
                    1 -> tablero.casilla2.set("estatus", casillaStatus)
                    2 -> tablero.casilla3.set("estatus", casillaStatus)
                    3 -> tablero.casilla4.set("estatus", casillaStatus)
                    4 -> tablero.casilla5.set("estatus", casillaStatus)
                    5 -> tablero.casilla6.set("estatus", casillaStatus)
                    6 -> tablero.casilla7.set("estatus", casillaStatus)
                    7 -> tablero.casilla8.set("estatus", casillaStatus)
                    8 -> tablero.casilla9.set("estatus", casillaStatus)
                    9 -> tablero.casilla10.set("estatus", casillaStatus)
                    10 -> tablero.casilla11.set("estatus", casillaStatus)
                    11 -> tablero.casilla12.set("estatus", casillaStatus)
                    12 -> tablero.casilla13.set("estatus", casillaStatus)
                    13 -> tablero.casilla14.set("estatus", casillaStatus)
                    14 -> tablero.casilla15.set("estatus", casillaStatus)
                    15 -> tablero.casilla16.set("estatus", casillaStatus)
                }
            }
        }
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
                loadGame()

                if(turnFinished()) {

                    //tablero.estatus = 2
                    if(gotAPoint()) {
                        updateScore()
                    } else {
                        hideCards()
                    }
                    if(getPlayerNumber() == 1) {
                        tablero.turno = 2
                    } else {
                        tablero.turno = 1
                    }
                }
                saveTablero()
            }
        } else {
            cantClick()
        }
    }
    fun updateScore() {
        val statusTablero = getStatusTableroList()
        val puntosPara = getPuntosParaList()
        val playerNumber = getPlayerNumber()
        for(i in 0..15) {
            // si esta volteada y no tiene punto para nadie
            if(statusTablero[i].toInt() == 1 && puntosPara[i].toInt() == 0) {
                when (i) {
                    0 -> tablero.casilla1.set("puntoPara", playerNumber)
                    1 -> tablero.casilla2.set("puntoPara", playerNumber)
                    2 -> tablero.casilla3.set("puntoPara", playerNumber)
                    3 -> tablero.casilla4.set("puntoPara", playerNumber)
                    4 -> tablero.casilla5.set("puntoPara", playerNumber)
                    5 -> tablero.casilla6.set("puntoPara", playerNumber)
                    6 -> tablero.casilla7.set("puntoPara", playerNumber)
                    7 -> tablero.casilla8.set("puntoPara", playerNumber)
                    8 -> tablero.casilla9.set("puntoPara", playerNumber)
                    9 -> tablero.casilla10.set("puntoPara", playerNumber)
                    10 -> tablero.casilla11.set("puntoPara", playerNumber)
                    11 -> tablero.casilla12.set("puntoPara", playerNumber)
                    12 -> tablero.casilla13.set("puntoPara", playerNumber)
                    13 -> tablero.casilla14.set("puntoPara", playerNumber)
                    14 -> tablero.casilla15.set("puntoPara", playerNumber)
                    15 -> tablero.casilla16.set("puntoPara", playerNumber)
                }
            }
        }
    }

    fun changeColor1(cardView: CardView) {
        cardView.setCardBackgroundColor(green)
    }
    fun changeColor2(cardView: CardView) {
        cardView.setCardBackgroundColor(red)
    }
    fun changeColor3(cardView: CardView) {
        cardView.setCardBackgroundColor(white)
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


    /* fun EnEspera(){  //-------------------------------------------------- En espera de turno
      CardView.setOnClickListener { View ->
          val builder = AlertDialog.Builder(this)
          builder.setMessage("Espera tu turno")
              .setCancelable(false)
          val alert = builder.create()
          alert.show()
      }
  }*/

    fun Ganador(){
        //-------------------------------------------------- Ganaste
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Ganaste! \n Tu puntuación es:")
            .setCancelable(false)
        val alert = builder.create()
        alert.show()
    }

    fun Perdiste(){  //-------------------------------------------------- Perdiste
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Perdiste! \n Tu puntuación es: ")
            .setCancelable(false)
        val alert = builder.create()
        alert.show()
    }

    fun loadGame() {
        puntaje1.text = tablero.puntos1.toString()
        puntaje2.text = tablero.puntos2.toString()

        var statusTablero = getStatusTableroList()
        var puntosParaList = getPuntosParaList()
        var images = getImagenList()
        var playerNumber = getPlayerNumber()

        for(i in 0..15) {
            if(statusTablero[i].toInt() == 0) {
                imageViews[i].setImageResource(cardBack)
                changeColor3(cardViews[i])
            } else {
                val id = getResources().getIdentifier(images[i], "drawable", getPackageName())
                imageViews[i].setImageResource(id)

                // si esta volteada y tiene punto para
                if(statusTablero[i].toInt() == 1 && puntosParaList[i].toInt() == 1) {
                    changeColor1(cardViews[i])
                }
                if(statusTablero[i].toInt() == 1 && puntosParaList[i].toInt() == 2) {
                    changeColor2(cardViews[i])
                }
            }
        }
    }
}