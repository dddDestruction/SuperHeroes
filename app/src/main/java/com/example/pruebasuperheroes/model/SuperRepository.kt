package com.example.pruebasuperheroes.model

import android.telecom.Call
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pruebasuperheroes.model.api.RetrofitClient
import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import retrofit2.Callback
import retrofit2.Response

class SuperRepository():ISuperRepository {

    var superHeroes = MutableLiveData<MutableList<SuperHeroe>>(mutableListOf<SuperHeroe>())

    override fun loadData() {
        val retrofit = RetrofitClient.retrofitInstance()
        val call = retrofit.getAllPosts()
        call.enqueue(object : Callback<ArrayList<SuperHeroe>>{
            override fun onResponse(
                call: retrofit2.Call<ArrayList<SuperHeroe>>,
                response: Response<ArrayList<SuperHeroe>>
            ) {
                response.body()?.map {
                    Log.d("AAA", "${it.name}")
                    superHeroes.value!!.add(it)
                }
            }

            override fun onFailure(call: retrofit2.Call<ArrayList<SuperHeroe>>, t: Throwable) {
                Log.d("AAA", "Error: " + t)
            }
        })
    }

    override fun insertOnRoom(lista: MutableList<SuperHeroe>) {
        TODO("Not yet implemented")
    }

    override fun checkValues(dataRoom: MutableList<SuperHeroe>, dataApi: MutableList<SuperHeroe>) {
        TODO("Not yet implemented")
    }

}