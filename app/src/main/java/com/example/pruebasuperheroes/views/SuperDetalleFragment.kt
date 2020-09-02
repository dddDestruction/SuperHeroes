package com.example.pruebasuperheroes.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.pruebasuperheroes.R
import com.example.pruebasuperheroes.model.pojo.SuperHeroe

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [SuperDetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuperDetalleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var constantes = Constantes()
    private var intelligence: Int? = null
    private var strength: Int? = null
    private var speed: Int? = null
    private var durability: Int? = null
    private var power: Int? = null
    private var combat: Int? = null
    private var nombre: String? = null
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            intelligence = it.getInt(constantes.INTELLIGENCE)
            strength = it.getInt(constantes.STRENGHT)
            speed = it.getInt(constantes.SPEED)
            durability = it.getInt(constantes.DURABILITY)
            power = it.getInt(constantes.POWER)
            combat = it.getInt(constantes.COMBAT)
            nombre = it.getString(constantes.POWER)
            url = it.getString(constantes.COMBAT)
        }
        Log.d("AAA", "en fragmento detalle")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_super_detalle, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(superHeroe: SuperHeroe) =
            SuperDetalleFragment().apply {
                arguments = Bundle().apply {
                    putInt(constantes.INTELLIGENCE, superHeroe.powerstats.intelligence)
                    putInt(constantes.STRENGHT, superHeroe.powerstats.strength)
                    putInt(constantes.SPEED, superHeroe.powerstats.speed)
                    putInt(constantes.DURABILITY, superHeroe.powerstats.durability)
                    putInt(constantes.POWER, superHeroe.powerstats.power)
                    putInt(constantes.COMBAT, superHeroe.powerstats.combat)
                    putString(constantes.NOMBRE, superHeroe.name)
                    putString(constantes.URL, superHeroe.images.sm)
                }
            }
    }
}
