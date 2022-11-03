package com.example.myshoppinglist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorLiProducto(context: Context, private var Datospro: List<listProducto>)
    : RecyclerView.Adapter<AdaptadorLiProducto.ViewHolderPro>(){

    class ViewHolderPro(itemView: View): RecyclerView.ViewHolder(itemView){


        var txtNombre : TextView = itemView.findViewById(R.id.txtNombrePro)
        var txtDescripcion : TextView = itemView.findViewById(R.id.txtDescripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPro {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lis_producto, parent,false)
        return ViewHolderPro(view)
    }

    override fun onBindViewHolder(holder: ViewHolderPro, position: Int) {
        val product = Datospro [position]
        Log.e("Adaptador","$product")
        holder.txtNombre.text = product.nombre
        holder.txtDescripcion.text = product.descripcion



    }

    override fun getItemCount(): Int = Datospro.size
}