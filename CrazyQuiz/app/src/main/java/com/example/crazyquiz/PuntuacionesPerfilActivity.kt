package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crazyquiz.modelo.puntuaciones
import kotlinx.android.synthetic.main.activity_puntuaciones_perfil.*

class PuntuacionesPerfilActivity : AppCompatActivity(),RecyclerAdapter.OnPuntajeClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntuaciones_perfil)
        setupRecyclerView()


    }

    private fun setupRecyclerView() {
        reciclerview.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration((DividerItemDecoration(this,DividerItemDecoration.VERTICAL)))
        val listPuntaje: List<puntuaciones> = listOf(
            puntuaciones(
                "Chirimole",
                "https://www.tierragamer.com/wp-content/uploads/2019/08/One-Piece-Monkey-D-Luffy-Cosplay-Gato.jpg"
            ),
            puntuaciones(
                "Flerky",
                "https://i.pinimg.com/originals/cc/c6/da/ccc6da24c9cf69967fd65061433af9ed.jpg"
            ),
            puntuaciones(
                "Bola",
                "https://i.pinimg.com/originals/65/37/49/65374935e22d777a2d0696466900cead.png"
            )
        )

        recyclerView.adapter = RecyclerAdapter(this, listPuntaje,this)
    }

    override fun onImageClick(imagen: String) {
     val intent = Intent(this,PerfilDetail::class.java)
        intent.putExtra("imageUrl", imagen)
        startActivity(intent)

    }

    override fun onItemClick(nombre: String) {
        Toast.makeText(this,"Este perfil es de: $nombre", Toast.LENGTH_SHORT).show()
    }
}

