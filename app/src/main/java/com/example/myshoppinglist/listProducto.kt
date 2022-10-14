package com.example.myshoppinglist

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class listProducto (

    @PrimaryKey (autoGenerate = true) var idProducto: Int,
    @ColumnInfo(name = "Nombre") val nombre: String?,
    @ColumnInfo(name = "Descripcion") val descripcion: String,
    @ColumnInfo(name = "Categoria") val categoria: String?
)

