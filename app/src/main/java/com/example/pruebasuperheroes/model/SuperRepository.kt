package com.example.pruebasuperheroes.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pruebasuperheroes.model.api.RetrofitClient
import com.example.pruebasuperheroes.model.db.SuperDBManager
import com.example.pruebasuperheroes.model.db.SuperDao
import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import kotlinx.coroutines.CoroutineScope
import retrofit2.Callback
import retrofit2.Response

class SuperRepository(context: Context, scope: CoroutineScope):ISuperRepository {

    val superDBManager = SuperDBManager(context, scope)
    var superHeroes = superDBManager.superHeroe
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
                    listaDataApi.add(it)
                    //checkValues(it)
                }
                superDBManager.insert(listaDataApi)
                //superHeroes = MutableLiveData(listaDataApi)
            }

            override fun onFailure(call: retrofit2.Call<ArrayList<SuperHeroe>>, t: Throwable) {
                Log.d("AAA", "Error: " + t)
            }
        })
    }

    override fun insertOnRoom(valor: SuperHeroe) {
        Log.d("AAA", "Lista ${valor.id}")
        //superDBManager.insert(valor)
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