package com.example.pruebasuperheroes.model

import com.example.pruebasuperheroes.model.pojo.SuperHeroe

interface ISuperRepository {
    fun loadData()
    fun insertOnRoom(lista:MutableList<SuperHeroe>)
    fun checkValues(dataRoom: MutableList<SuperHeroe>,dataApi: MutableList<SuperHeroe>)
}