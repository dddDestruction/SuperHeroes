package com.example.pruebasuperheroes.model.db

import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import kotlinx.coroutines.Job

interface ISuperDBManager {
    fun insert(valor: List<SuperHeroe>): Job
}