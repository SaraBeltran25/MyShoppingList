package com.example.myshoppinglist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCate (private  val datoslist:ArrayList<listElement>/*, private var producto: cellClikListenerProductos*/)
    :RecyclerView.Adapter<AdaptadorCate.ViewHolderCat>(){



    class ViewHolderCat(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val txtNombreCategoria : TextView = itemView.findViewById(R.id.txtNombreCategoria)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCat {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_elemet, parent,false)
        return ViewHolderCat(view)
    }

    override fun onBindViewHolder(holder: ViewHolderCat, position: Int) {
        val categoria = datoslist [position]
        holder.imageView.setImageResource(categoria.image)
        holder.txtNombreCategoria.text = categoria.Categoria

        /*holder.itemView.setOnClickListener{
            producto.clickProducto(categoria)
            Log.e("Click", "di click")
        }*/

    }

    override fun getItemCount(): Int = datoslist.size
}