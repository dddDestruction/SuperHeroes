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
import com.example.pruebasuperheroes.views.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        crearFragmento()
    }

    fun crearFragmento(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, MainFragment.newInstance(), "Main")
            .commit()
    }
}
