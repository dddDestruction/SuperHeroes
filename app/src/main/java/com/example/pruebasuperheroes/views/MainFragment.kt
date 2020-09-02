package com.example.pruebasuperheroes.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.pruebasuperheroes.R
import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import com.example.pruebasuperheroes.viewmodel.SuperViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(), IMainFragment, FragmentCallback {


    var listaSuperHeroes = mutableListOf<SuperHeroe>()
    //var superAdapter = SuperAdapter(listaSuperHeroes)
    var recyclerView = recycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        initViewModel()
        recyclerView = view.recycler
        initRecyclerView()
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun initViewModel() {
        val model = ViewModelProvider(this).get(SuperViewModel::class.java)

         model.superHeroes.observe(this.viewLifecycleOwner, Observer {
             recyclerView.adapter = SuperAdapter(it, this)
        })
        model.repository.loadData()
    }

    override fun initRecyclerView() {
        recyclerView.adapter = SuperAdapter(listaSuperHeroes, this)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    override fun notificarClick(superHeroe: SuperHeroe) {
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, SuperDetalleFragment.newInstance(superHeroe), "detalle")
            .commit()
    }

}