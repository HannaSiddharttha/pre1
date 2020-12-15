package com.example.crazyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crazyquiz.db.GameWithSelectedQuestions
import com.example.crazyquiz.db.QuizRepository
import com.example.crazyquiz.db.SelectedQuestionAndQuestion
import com.example.crazyquiz.db.Users
import com.example.crazyquiz.modelo.Puntuaciones
import kotlinx.android.synthetic.main.activity_puntuaciones_perfil.*

class PuntuacionesPerfilActivity : AppCompatActivity(),RecyclerAdapter.OnPuntajeClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var repository: QuizRepository
    private  lateinit var user: Users

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntuaciones_perfil)
        setSupportActionBar(findViewById(R.id.toolbar))
        repository = QuizRepository(this.application)
        recyclerView = findViewById(R.id.reciclerview)

        var savedUser = ModelPreferencesManager.get<Users>("USER")
        if(savedUser != null) {
            user = savedUser
            setupRecyclerView()
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun showItemToast(msg:String) : Boolean {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.date_menu_item,
            R.id.points_menu_item, -> showItemToast(item.title.toString())
            else -> super.onOptionsItemSelected(item)

        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupRecyclerView() {
        reciclerview.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration((DividerItemDecoration(this,DividerItemDecoration.VERTICAL)))


        val listPuntaje = mutableListOf<Puntuaciones>()
        var games = repository.getGamesByUser(user.userId);

//        var currentGame = repository.getActiveGameByUser(model.user.userId)
        val observer = Observer<List<GameWithSelectedQuestions>> { games ->
            for(game in games) {
                listPuntaje.add(Puntuaciones(game.user.userName,"https://www.tierragamer.com/wp-content/uploads/2019/08/One-Piece-Monkey-D-Luffy-Cosplay-Gato.jpg",game))
            }
            recyclerView.adapter = RecyclerAdapter(this, listPuntaje,this)
        }
        games.observe(this, observer)

        /*
        val listPuntaje: List<Puntuaciones> = listOf(
            Puntuaciones(
                "Chirimole",
                "https://www.tierragamer.com/wp-content/uploads/2019/08/One-Piece-Monkey-D-Luffy-Cosplay-Gato.jpg"
            ),
            Puntuaciones(
                "Flerky",
                "https://i.pinimg.com/originals/cc/c6/da/ccc6da24c9cf69967fd65061433af9ed.jpg"
            ),
            Puntuaciones(
                "Bola",
                "https://i.pinimg.com/originals/65/37/49/65374935e22d777a2d0696466900cead.png"
            )
        )
        */

        //recyclerView.adapter = RecyclerAdapter(this, listPuntaje,this)
    }

    override fun onImageClick(imagen: String) {
     val intent = Intent(this,PerfilDetail::class.java)
        intent.putExtra("imageUrl", imagen)
        startActivity(intent)

    }

    override fun onItemClick(game: GameWithSelectedQuestions) {
        Toast.makeText(this,"Este perfil es de: ${game.game.score} ${game.game.date}", Toast.LENGTH_SHORT).show()
    }
}

