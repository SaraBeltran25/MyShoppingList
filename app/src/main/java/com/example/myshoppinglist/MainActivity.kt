package com.example.myshoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var datoslist : ArrayList<listElement>
    private lateinit var adaptadorCate: AdaptadorCate


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        datoslist = ArrayList()

        datoslist.add(listElement(R.drawable.vege,"Frutas y verduras"))
        datoslist.add(listElement(R.drawable.carne,"Carnes"))
        datoslist.add(listElement(R.drawable.limpieza,"Articulos de limpieza"))
        datoslist.add(listElement(R.drawable.panyharina,"Cereales, Pasta y Harina"))
        datoslist.add(listElement(R.drawable.bebidas,"Bebidas"))

        adaptadorCate = AdaptadorCate(datoslist)
        recyclerView.adapter = adaptadorCate


        adaptadorCate.onItemClick = {
            val intent = Intent(this, Mostrar::class.java)
            intent.putExtra("", it)
            startActivity(intent)
        }
    }

    /*fun mostrarPantalla(v: View){
        val intent = Intent(this, Mostrar::class.java)
    }*/
}