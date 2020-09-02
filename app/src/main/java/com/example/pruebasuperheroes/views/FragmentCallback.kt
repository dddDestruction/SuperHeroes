package com.example.pruebasuperheroes.views

import com.example.pruebasuperheroes.model.pojo.SuperHeroe

interface FragmentCallback {
    fun notificarClick(superHeroe: SuperHeroe)
}