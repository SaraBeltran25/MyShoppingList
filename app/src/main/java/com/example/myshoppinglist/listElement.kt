package com.example.myshoppinglist

import android.os.Parcel
import android.os.Parcelable

data class listElement (val image:Int, val Categoria: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(Categoria)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<listElement> {
        override fun createFromParcel(parcel: Parcel): listElement {
            return listElement(parcel)
        }

        override fun newArray(size: Int): Array<listElement?> {
            return arrayOfNulls(size)
        }
    }
}