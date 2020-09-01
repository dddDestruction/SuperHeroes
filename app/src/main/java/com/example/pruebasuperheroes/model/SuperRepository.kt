package com.example.pruebasuperheroes.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pruebasuperheroes.model.api.RetrofitClient
import com.example.pruebasuperheroes.model.db.SuperDao
import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import retrofit2.Callback
import retrofit2.Response

class SuperRepository(private val superDao: SuperDao):ISuperRepository {

    var superHeroes = superDao.getAll()
    var listaDataApi = mutableListOf<SuperHeroe>()

    override fun loadData() {
        val retrofit = RetrofitClient.retrofitInstance()
        val call = retrofit.getAllPosts()
        call.enqueue(object : Callback<ArrayList<SuperHeroe>>{
            override fun onResponse(
                call: retrofit2.Call<ArrayList<SuperHeroe>>,
                response: Response<ArrayList<SuperHeroe>>
            ) {
                response.body()?.map {
                    Log.d("AAA", "${it.name} primera imagen ${it.images.xs}")
                    checkValues(it)
                }
                superHeroes = MutableLiveData(listaDataApi)
            }

            override fun onFailure(call: retrofit2.Call<ArrayList<SuperHeroe>>, t: Throwable) {
                Log.d("AAA", "Error: " + t)
            }
        })
    }

    override fun insertOnRoom(valor: SuperHeroe) {
        Log.d("AAA", "Lista ${valor.id}")
        superDao.insertSuper(valor)
    }

    override fun checkValues(dataApi: SuperHeroe) {
        var count = 0
        for (ele in superHeroes.value!!){
            if (ele.id == dataApi.id){
                count = 1
                Log.d("AAA", "count ${count}")
            }
        }

        if (count == 0){
            insertOnRoom(dataApi)
        }
        listaDataApi.add(dataApi)
    }
}