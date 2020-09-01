package com.example.pruebasuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pruebasuperheroes.model.SuperRepository
import com.example.pruebasuperheroes.model.db.SuperDB
import com.example.pruebasuperheroes.viewmodel.SuperViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProvider(this).get(SuperViewModel::class.java)

        model.superHeroes.observe(this, Observer {
            for (ele in it){
                Log.d("AAA", "Lista en Main Super id ${ele.id}")
            }
        })
        model.repository.loadData()
    }
}
