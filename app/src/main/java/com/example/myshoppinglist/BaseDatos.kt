package com.example.myshoppinglist

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [listProducto::class],
    version = 2
)

abstract class BaseDatos : RoomDatabase() {
    abstract fun ProductoDao(): Sentencias

}