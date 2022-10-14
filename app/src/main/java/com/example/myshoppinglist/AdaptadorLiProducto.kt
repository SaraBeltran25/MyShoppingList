package com.example.myshoppinglist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorLiProducto (context :Context, private  val Datospro:List<listProducto>)
    : RecyclerView.Adapter<AdaptadorLiProducto.ViewHolderPro>(){

    class ViewHolderPro(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtId : TextView = itemView.findViewById(R.id.txtId)
        val txtNombre : TextView = itemView.findViewById(R.id.txtNombre)
        val txtDescripcion : TextView = itemView.findViewById(R.id.txtDescripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPro {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lis_producto, parent,false)
        return AdaptadorLiProducto.ViewHolderPro(view)


    }

    override fun onBindViewHolder(holder: ViewHolderPro, position: Int) {
        val product = Datospro [position]
        holder.txtNombre.text = product.nombre
        holder.txtDescripcion.text = product.descripcion
    }

    override fun getItemCount(): Int = Datospro.size


}