package com.example.mylistapersonas.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mylistapersonas.MainActivity
import com.example.mylistapersonas.Persona
import com.example.mylistapersonas.R


class SecondFragment : Fragment(R.layout.fragment_second,) {
    //private var persona=persona1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle:Bundle? = null
        var persona:Persona? = null
        val btnArrowBack =view.findViewById<ImageView>(R.id.arrowBack)
        val imagePerson =view.findViewById<ImageView>(R.id.ivPersona)
        val name = view.findViewById<TextView>(R.id.namePersona)
        val age = view.findViewById<TextView>(R.id.agePersona)
        val superPersona = view.findViewById<TextView>(R.id.superPersona)
        bundle = arguments
        // de esta manera se Cast as mas la clase que quiera
        persona = bundle?.getSerializable("persona") as Persona

        btnArrowBack.setOnClickListener {
            (activity as MainActivity).myOnBackPressed(bundle)
        }
        Glide.with(requireContext()).load(persona.photo).into(imagePerson)
        name.text = persona.name
        age.text = persona.age.toString()
        superPersona.text = persona.superUser.toString()

    }
}