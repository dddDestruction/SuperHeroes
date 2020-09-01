package com.example.pruebasuperheroes.model

import com.example.pruebasuperheroes.model.pojo.SuperHeroe

interface ISuperRepository {
    fun loadData()
    fun insertOnRoom(valor:SuperHeroe)
    fun checkValues(dataApi: SuperHeroe)
}