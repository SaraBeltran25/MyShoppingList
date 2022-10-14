package com.example.myshoppinglist

import android.app.Application
import androidx.room.Room

class MyShoppingList : Application()  {
    lateinit var room: BaseDatos

    override fun onCreate() {
        super.onCreate()
        room =  Room.databaseBuilder(this, BaseDatos::class.java, "productos").build()
    }
}