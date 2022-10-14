package com.example.myshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.lis_producto.*
import kotlinx.coroutines.launch

class AgregarProductos : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var txtDescripcion: EditText
    lateinit var txtNombre: EditText
    lateinit var txtId: EditText
    lateinit var SpCategoria: Spinner
    lateinit var db : MyShoppingList
    val Categoria = arrayOf("Frutas y verduras", "Carnes", "Articulos de limpieza",
        "Cereales, Pasta y Harina", "Bebidas")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_productos)
        txtDescripcion = findViewById(R.id.edDescripcionP)
        txtNombre= findViewById(R.id.edNombreP)
        txtId= findViewById(R.id.edId)
        SpCategoria= findViewById(R.id.spCategoria)

        db = this.application as MyShoppingList
        supportActionBar?.hide()

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, Categoria)

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        SpCategoria.adapter = adaptador
        SpCategoria.onItemSelectedListener = this

    }

    fun agregarProducto(v: View) {

        //Aqui agrego un producto a la base de datos
        val id= txtId.text.toString()
        val Nombre= txtNombre.text.toString()
        val Descripcion = txtDescripcion.text.toString()
        val Categoria = SpCategoria.toString()
        if(id.equals("") or Nombre.equals("") or Descripcion.equals("") or Categoria.equals("")){
            Toast.makeText(this, "Error complete todos los datos", Toast.LENGTH_LONG).show()
        }
        else {
            lifecycleScope.launch {
                val prod = listProducto (0, Nombre, Descripcion, Categoria)
                db.room.ProductoDao().insert(prod)
            }
            Toast.makeText(this, "Producto registrado", Toast.LENGTH_LONG).show()
            finish()

        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Log.e("SPINNER", "Se selecciono $p2")
        val categoria: String = Categoria[p2]

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}