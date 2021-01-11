package com.example.crazyquiz.firebaseModels

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class Tablero (
    var turno: Int? = 0,
    var estatus: Int? = 1,
    var puntos1: Int? = 0,
    var puntos2: Int? = 0,
    var jugador1: MutableMap<String, Any> = HashMap(),
    var jugador2: MutableMap<String, Any> = HashMap(),
    var casilla1: MutableMap<String, Any> = HashMap(),
    var casilla2: MutableMap<String, Any> = HashMap(),
    var casilla3: MutableMap<String, Any> = HashMap(),
    var casilla4: MutableMap<String, Any> = HashMap(),
    var casilla5: MutableMap<String, Any> = HashMap(),
    var casilla6: MutableMap<String, Any> = HashMap(),
    var casilla7: MutableMap<String, Any> = HashMap(),
    var casilla8: MutableMap<String, Any> = HashMap(),
    var casilla9: MutableMap<String, Any> = HashMap(),
    var casilla10: MutableMap<String, Any> = HashMap(),
    var casilla11: MutableMap<String, Any> = HashMap(),
    var casilla12: MutableMap<String, Any> = HashMap(),
    var casilla13: MutableMap<String, Any> = HashMap(),
    var casilla14: MutableMap<String, Any> = HashMap(),
    var casilla15: MutableMap<String, Any> = HashMap(),
    var casilla16: MutableMap<String, Any> = HashMap(),

) {
}