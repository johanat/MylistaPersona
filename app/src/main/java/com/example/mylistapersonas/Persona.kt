package com.example.mylistapersonas

import android.os.Parcelable

//data means you can only save attributes

data class Persona(
    val name:String,
    val age:Int,
    var superUser:Boolean,
    val photo: String,
    var isBlue: Boolean = false,
    var selected: Boolean = false
): java.io.Serializable
