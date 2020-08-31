package com.example.pruebasuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebasuperheroes.model.SuperRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SuperRepository().loadData()
    }
}
