package com.dam.apuntes_examen

//data class, que no class ( clase solo para guardar datos
data class Animales(
    //el adapter usara esto para rellenar cada fila del reclyclerView

    val nombre: String,
    val tipoAlimentacion: String,
    val tipoReproduccion: String
)
