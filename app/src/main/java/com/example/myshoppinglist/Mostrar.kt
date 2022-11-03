package com.example.myshoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class Mostrar : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var db :MyShoppingList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)
        recycler = findViewById(R.id.rvListPro)

        db = this.application as MyShoppingList


    }

    override fun onPostResume() {
        super.onPostResume()
        actualizarRecycler()
    }
    fun actualizarRecycler(){
        lifecycleScope.launch{
            val lista= db.room.ProductoDao().getAll()
            actualizarRecyclerDespues(lista)
        }
    }
    fun actualizarRecyclerDespues(list: List<listProducto>){
        val adaptador = AdaptadorLiProducto(this, list)
        recycler.adapter = adaptador
    }


    fun AgregarPantalla(v: View) {
        val intent = Intent(this, AgregarProductos::class.java)
        startActivity(intent)
    }

}
