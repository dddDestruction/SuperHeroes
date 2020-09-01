package com.example.pruebasuperheroes.model.pojo

import androidx.room.ColumnInfo

data class Imagenes (
    @ColumnInfo(name = "imagen_xs") var xs:String,
    @ColumnInfo(name = "imagen_sm") var sm:String,
    @ColumnInfo(name = "imagen_md") var md:String,
    @ColumnInfo(name = "imagen_lg") var lg:String
)