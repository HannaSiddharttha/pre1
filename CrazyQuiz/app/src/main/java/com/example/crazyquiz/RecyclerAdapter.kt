package com.example.crazyquiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crazyquiz.base.BaseViewHolder
import com.example.crazyquiz.modelo.puntuaciones
import kotlinx.android.synthetic.main.puntaje_row.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapter (private val context: Context,val listaPuntaje:List<puntuaciones>,val itemClickListener:OnPuntajeClickListener): RecyclerView.Adapter<BaseViewHolder<*>>(){

    interface OnPuntajeClickListener{
      fun onImageClick(imagen: String)
      fun onItemClick(nombre: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PuntajeViewHolder(LayoutInflater.from(context).inflate(R.layout.puntaje_row,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
       when(holder){
           is PuntajeViewHolder -> holder.bind(listaPuntaje[position],position)
           else -> throw IllegalArgumentException("Se olvido de pasar l viewholder en el bind")
       }
    }

    override fun getItemCount(): Int = listaPuntaje.size

    inner class PuntajeViewHolder(itemView: View):BaseViewHolder<puntuaciones>(itemView){
        override fun bind(item: puntuaciones, position: Int) {
            itemView.setOnClickListener{itemClickListener.onItemClick(item.nombre)}
            itemView.img_perfil.setOnClickListener{itemClickListener.onImageClick(item.imagen)}
            Glide.with(context).load(item.imagen).into(itemView.img_perfil)
            itemView.txt_usuario1.text = item.nombre
        }
    }
}