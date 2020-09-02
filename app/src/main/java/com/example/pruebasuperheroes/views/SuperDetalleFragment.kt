package com.example.pruebasuperheroes.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.pruebasuperheroes.R
import com.example.pruebasuperheroes.databinding.FragmentSuperDetalleBinding
import com.example.pruebasuperheroes.model.pojo.SuperHeroe
import com.squareup.picasso.Picasso

class SuperDetalleFragment : Fragment() {

    lateinit var heroe:SuperHeroe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        Log.d("AAA", "en fragmento detalle")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentSuperDetalleBinding>(
            inflater,
            R.layout.fragment_super_detalle,
            container,
            false)
        binding.heroe = heroe
        Picasso.get()
            .load(heroe.images.lg)
            .into(binding.imagen)


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(superHeroe: SuperHeroe) =
            SuperDetalleFragment().apply {
                heroe = superHeroe
                arguments = Bundle().apply {
                }
            }
    }
}
