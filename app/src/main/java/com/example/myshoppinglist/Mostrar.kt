package com.example.myshoppinglist

import android.content.Intent
import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class Mostrar : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var db : MyShoppingList
    lateinit var  categoria1: String
    lateinit var txtNombre : TextView
    lateinit var chkSub : CheckBox
    lateinit var Buscar : EditText
    lateinit var Nombreproducto : String
    //lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)
        recycler = findViewById(R.id.rvListPro)
        db = this.application as MyShoppingList

        Buscar = findViewById(R.id.edBuscar)

        //txtNombre = findViewById(R.id.txtNombrePro)
        //chkSub = findViewById(R.id.chkSub)

        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1

        )*/

        /*supportActionBar?.hide()*/

    }

    override fun onPostResume() {
        super.onPostResume()
        actualizarRecycler()
    }
    fun actualizarRecycler(){
        lifecycleScope.launch{
            //val lista= db.room.ProductoDao().getAll()
             categoria1= "Frutas y verduras"
            val lista= db.room.ProductoDao().getByCategoria( categoria1)
            Log.e("DATOS", "cantidad ${lista.size}")
            actualizarRecyclerDespues(lista)
        }

        //suspend fun getAll(): List<listProducto>
    }
    fun actualizarRecyclerDespues(list: List<listProducto>){
        val adaptador = AdaptadorLiProducto(this, list)
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter = adaptador
    }

    fun AgregarPantalla(v: View) {
        val intent = Intent(this, AgregarProductos::class.java)
        startActivity(intent)
    }



    /*fun clickCheck(v:View){
       if(chkSub.isChecked == true)
           txtNombre.setPaintFlags(txtNombre.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
       else
            txtNombre.typeface = Typeface.DEFAULT

    }*/


    /*fun BuscarProducto(v: View){
        //idDoctoor ="1234"
        lifecycleScope.launch{
            val lista= db.room.ProductoDao().getByNombreProducto (Nombreproducto)
            actualizarRecyclerDespues(lista)

        }
    }*/


}
