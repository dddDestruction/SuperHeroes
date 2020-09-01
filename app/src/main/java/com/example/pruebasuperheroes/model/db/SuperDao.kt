package com.example.pruebasuperheroes.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebasuperheroes.model.pojo.SuperHeroe

@Dao
interface SuperDao {

    //Inserta varios valores en Room DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSuper(vararg heroes: SuperHeroe)

    //Obtiene todos los valores desde Room DB
    @Query("SELECT * FROM super_heroes")
    fun getAll(): LiveData<List<SuperHeroe>>
}
