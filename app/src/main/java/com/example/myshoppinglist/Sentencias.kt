package com.example.myshoppinglist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface Sentencias {
    @Query("SELECT * FROM listProducto")
    suspend fun getAll(): List<listProducto>

    @Update
    suspend fun update(product:listProducto)

    @Insert
    suspend fun insert(product:listProducto)
}