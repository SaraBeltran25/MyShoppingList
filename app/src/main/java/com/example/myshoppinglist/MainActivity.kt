package com.example.myshoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var datoslist: ArrayList<listElement>
    private lateinit var adaptadorCate: AdaptadorCate
    lateinit var db: MyShoppingList


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        datoslist = ArrayList()

        datoslist.add(listElement(1, R.drawable.vege, "Frutas y verduras"))
        datoslist.add(listElement(2, R.drawable.carne, "Carnes"))
        datoslist.add(listElement(3, R.drawable.limpieza, "Articulos de limpieza"))
        datoslist.add(listElement(4, R.drawable.panyharina, "Cereales, Pasta y Harina"))
        datoslist.add(listElement(5, R.drawable.bebidas, "Bebidas"))

        adaptadorCate = AdaptadorCate(datoslist)
        recyclerView.adapter = adaptadorCate

    }

    override fun onPostResume() {
        super.onPostResume()
        actualizarRecycler()
    }

    fun actualizarRecycler() {
        lifecycleScope.launch{
            val lista = db.room.ProductoDao().getAll()
            actualizarRecyclerDespues(lista)
        }
    }

    fun actualizarRecyclerDespues(list: List<listProducto>){
        val adaptador = AdaptadorLiProducto(this, list)
        recyclerView.adapter = adaptador
    }

    fun abrirMostra(v: View){
        val intent= Intent(this, Mostrar ::class.java)
        startActivity(intent)
    }

}