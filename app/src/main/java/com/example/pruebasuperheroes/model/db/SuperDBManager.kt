package com.example.pruebasuperheroes.model.db

import android.content.Context
import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SuperDBManager(context: Context, val scope: CoroutineScope):ISuperDBManager {

    val superDao = SuperDB.getDatabase(context).dao()
    var superHeroe = superDao.getAll()

    override fun insert(valor: SuperHeroe) = scope.launch {
        if (valor != null){
            superDao.insertSuper(valor)
        }
    }
}