package com.example.pruebasuperheroes.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebasuperheroes.model.SuperRepository

class SuperViewModel(application: Application) : AndroidViewModel(application)  {

    val repository = SuperRepository(application, viewModelScope)
    var superHeroes = repository.superHeroes

}