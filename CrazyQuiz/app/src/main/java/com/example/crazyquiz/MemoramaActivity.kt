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

        //var value = myRef.
        //var casilla1 = myRef.child("casilla1");

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                //val post = dataSnapshot.getValue<Post>()
//                val estatusTablero = dataSnapshot.child("estatus").getValue()
                val tablero2 = dataSnapshot.value
                var tableroFirebase = dataSnapshot.getValue(Tablero::class.java)
                //var esperaFirebase = dataSnapshot.getValue(Espera::class.java)
                //var esperaFirebase2 = dataSnapshot.child("espera").getValue("lista")
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

        val images: MutableList<Int> = mutableListOf(
            gatocool,
            gatoduren,
            gatoincomodo,
            gatokhe,
            gatolopuseaqui,
            gatobatma,
            gatosospechozo,
            gatotrabajando,
            gatocool,
            gatoduren,
            gatoincomodo,
            gatokhe,
            gatolopuseaqui,
            gatobatma,
            gatosospechozo,
            gatotrabajando
        )
        val cardViews = arrayOf(
            cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8,
            cardView9,cardView10,cardView11,cardView12,cardView13,cardView14,cardView15,cardView16
        )
        val imageViews = arrayOf(
            imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,
            imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16
        )
        val cardBack = ic_baseline_local_fire_department_24
        var clicked = 0
        var turnOver = false
        var lastClicked = -1

        images.shuffle()
        for (i in 0..15) {
            //buttons[i].text = "cardBack"
            //buttons[i].textSize = 0.0F
                imageViews[i].setImageResource(images[i])
            cardViews[i].setOnClickListener {
                Toast.makeText( this,
                    "Usuario incorrecto",
                    Toast.LENGTH_SHORT
                ).show()
            /*
                if (buttons[i].text == "cardBack" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked == 0) {
                        lastClicked = i
                    }
                    clicked++
                } else if (buttons[i].text !in "cardBack") {
                    buttons[i].setBackgroundResource(cardBack)
                    buttons[i].text = "cardBack"
                    clicked--
                }
                if (clicked == 2) {
                    turnOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                    }
                } else if (clicked == 0) {
                    turnOver = false
                }
                */
            }
        }
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
        val cardViews = arrayOf(
            cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8,
            cardView9,cardView10,cardView11,cardView12,cardView13,cardView14,cardView15,cardView16
        )
        val imageViews = arrayOf(
            imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,
            imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16
        )
        tablero = Tablero()
        var clicked = 0
        var turnOver = false
        var lastClicked = -1

        images.shuffle()

        tablero.casilla1.put("estatus",0)
        tablero.casilla1.put("imagen",getResources().getResourceEntryName(images[0]))
        tablero.casilla1.put("puntoPara", 0)
        tablero.casilla2.put("estatus",0)
        tablero.casilla2.put("imagen",getResources().getResourceEntryName(images[1]))
        tablero.casilla2.put("puntoPara", 0)
        tablero.casilla3.put("estatus",0)
        tablero.casilla3.put("imagen",getResources().getResourceEntryName(images[2]))
        tablero.casilla3.put("puntoPara", 0)
        tablero.casilla4.put("estatus",0)
        tablero.casilla4.put("imagen",getResources().getResourceEntryName(images[3]))
        tablero.casilla4.put("puntoPara", 0)
        tablero.casilla5.put("estatus",0)
        tablero.casilla5.put("imagen",getResources().getResourceEntryName(images[4]))
        tablero.casilla5.put("puntoPara", 0)
        tablero.casilla6.put("estatus",0)
        tablero.casilla6.put("imagen",getResources().getResourceEntryName(images[5]))
        tablero.casilla6.put("puntoPara", 0)
        tablero.casilla7.put("estatus",0)
        tablero.casilla7.put("imagen",getResources().getResourceEntryName(images[6]))
        tablero.casilla7.put("puntoPara", 0)
        tablero.casilla8.put("estatus",0)
        tablero.casilla8.put("imagen",getResources().getResourceEntryName(images[7]))
        tablero.casilla8.put("puntoPara", 0)
        tablero.casilla9.put("estatus",0)
        tablero.casilla9.put("imagen",getResources().getResourceEntryName(images[8]))
        tablero.casilla9.put("puntoPara", 0)
        tablero.casilla10.put("estatus",0)
        tablero.casilla10.put("imagen",getResources().getResourceEntryName(images[9]))
        tablero.casilla10.put("puntoPara", 0)
        tablero.casilla11.put("estatus",0)
        tablero.casilla11.put("imagen",getResources().getResourceEntryName(images[10]))
        tablero.casilla11.put("puntoPara", 0)
        tablero.casilla12.put("estatus",0)
        tablero.casilla12.put("imagen",getResources().getResourceEntryName(images[11]))
        tablero.casilla12.put("puntoPara", 0)
        tablero.casilla13.put("estatus",0)
        tablero.casilla13.put("imagen",getResources().getResourceEntryName(images[12]))
        tablero.casilla13.put("puntoPara", 0)
        tablero.casilla14.put("estatus",0)
        tablero.casilla14.put("imagen",getResources().getResourceEntryName(images[13]))
        tablero.casilla14.put("puntoPara", 0)
        tablero.casilla15.put("estatus",0)
        tablero.casilla15.put("imagen",getResources().getResourceEntryName(images[14]))
        tablero.casilla15.put("puntoPara", 0)
        tablero.casilla16.put("estatus",0)
        tablero.casilla16.put("imagen",getResources().getResourceEntryName(images[15]))
        tablero.casilla16.put("puntoPara", 0)

        for (i in 0..15) {
            //buttons[i].text = "cardBack"
            //buttons[i].textSize = 0.0F

            imageViews[i].setImageResource(images[i])
            //tablero.c

            cardViews[i].setOnClickListener {
                Toast.makeText( this,
                    "Usuario incorrecto",
                    Toast.LENGTH_SHORT
                ).show()
                /*
                    if (buttons[i].text == "cardBack" && !turnOver) {
                        buttons[i].setBackgroundResource(images[i])
                        buttons[i].setText(images[i])
                        if (clicked == 0) {
                            lastClicked = i
                        }
                        clicked++
                    } else if (buttons[i].text !in "cardBack") {
                        buttons[i].setBackgroundResource(cardBack)
                        buttons[i].text = "cardBack"
                        clicked--
                    }
                    if (clicked == 2) {
                        turnOver = true
                        if (buttons[i].text == buttons[lastClicked].text) {
                            buttons[i].isClickable = false
                            buttons[lastClicked].isClickable = false
                            turnOver = false
                            clicked = 0
                        }
                    } else if (clicked == 0) {
                        turnOver = false
                    }
                    */
            }
        }
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
        var casilla16status : Long = tablero.casilla15.get("estatus") as Long

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