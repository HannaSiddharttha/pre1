package com.example.crazyquiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.example.crazyquiz.R.drawable.*
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_memorama.*

class MemoramaActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama)

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

}