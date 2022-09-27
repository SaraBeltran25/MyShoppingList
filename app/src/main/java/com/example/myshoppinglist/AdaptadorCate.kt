package com.example.myshoppinglist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCate (private  val datoslist:ArrayList<listElement>)
    :RecyclerView.Adapter<AdaptadorCate.ViewHolderCat>(){

    var onItemClick : ((listElement) -> Unit)? = null

    class ViewHolderCat(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val txtNombre : TextView = itemView.findViewById(R.id.txtNombre)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCat {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_elemet, parent,false)
        return ViewHolderCat(view)
    }

    override fun onBindViewHolder(holder: ViewHolderCat, position: Int) {
        val categoria = datoslist [position]
        holder.imageView.setImageResource(categoria.image)
        holder.txtNombre.text = categoria.Categoria

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(categoria)
        }
    }

    override fun getItemCount(): Int = datoslist.size
}