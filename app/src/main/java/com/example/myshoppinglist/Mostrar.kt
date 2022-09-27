package com.example.myshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Mostrar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)

        val categoria = intent.getParcelableExtra<listElement>("categoria")
        if (categoria !=null){
            val textView : TextView = findViewById(R.id.txtNombre)
            textView.text = categoria.Categoria
        }
    }

}