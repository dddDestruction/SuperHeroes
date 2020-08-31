package com.example.pruebasuperheroes.model.api

import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import retrofit2.Call
import retrofit2.http.GET
import java.util.ArrayList

interface Api {
    @GET("all.json")
    fun getAllPosts(): Call<ArrayList<SuperHeroe>>
}