package com.example.pruebasuperheroes.model.pojo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "super_heroes")
class SuperHeroe(@PrimaryKey var id:Int,
                 var name:String,
                 @Embedded var images: Imagenes,
                 @Embedded var powerstats: PowerStats) {

}