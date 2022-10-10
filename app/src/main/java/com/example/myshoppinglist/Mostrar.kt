package com.example.myshoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Mostrar : AppCompatActivity() {
    lateinit var recycler: RecyclerView

    companion object{
        val p = ArrayList<listProducto>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)
        p.add(listProducto(1,"coca", "2.5 retornable"))
        p.add(listProducto(2,"coca", "1.5 retornable"))

        val adapt = AdaptadorLiProducto(this, p)
        recycler.adapter = adapt

        //val categoria = intent.getParcelableExtra<listElement>("categoria")
        //if (categoria != null) {
        //    val textView: TextView = findViewById(R.id.txtNombre)
        //    textView.text = categoria.Categoria
       // }
    }

    fun AgregarPantalla(v: View) {
        val intent = Intent(this, AgregarProductos::class.java)
        startActivity(intent)
    }


}
