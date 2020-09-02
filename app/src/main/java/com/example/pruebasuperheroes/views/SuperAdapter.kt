package com.example.pruebasuperheroes.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebasuperheroes.R
import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycler.view.*

class SuperAdapter(private var lista: List<SuperHeroe>, var listener:FragmentCallback) : RecyclerView.Adapter<SuperAdapter.SuperHolder>() {

    lateinit var  selectedItem:SuperHeroe

    class SuperHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val texto = itemView.textView
        val imagen = itemView.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperAdapter.SuperHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)

        return SuperHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: SuperAdapter.SuperHolder, position: Int) {
        var heroe = lista.get(position)
        holder.texto.text = heroe.name
        Picasso.get()
            .load(heroe.images.sm)
            .resize(400,400)
            .into(holder.imagen)
        holder.imagen.setOnClickListener{
            listener.notificarClick(heroe )
        }

    }

    fun update(list:MutableList<SuperHeroe>){
        lista = list
        notifyDataSetChanged()
    }
}