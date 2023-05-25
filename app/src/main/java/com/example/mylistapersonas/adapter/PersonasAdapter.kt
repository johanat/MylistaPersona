package com.example.mylistapersonas.adapter

import android.app.Person
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mylistapersonas.MainActivity
import com.example.mylistapersonas.Persona
import com.example.mylistapersonas.R

class PersonasAdapter(private val personasList: List<Persona>) :
    RecyclerView.Adapter<PersonasViewHolder>() {
    var lambda : ((Persona)->Unit)? = null
    val bundle = Bundle()
   // private val personGlobal : Persona?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonasViewHolder(
            layoutInflater.inflate(
                R.layout.item_lista_personas,
                parent,
                false

            )
        )
    }

    override fun getItemCount(): Int {
        return personasList.size

    }

    override fun onBindViewHolder(holder: PersonasViewHolder, position: Int) {

        // se llama cada vez que pinta un item

        val person = personasList[position]
        holder.render(person)

        // receptor
        // holder has all the elements, the View
        holder.setOnItemClicked{persona ->
            lambda?.invoke(persona)
            //  esta clase escucha los eventos
           Log.i("johana","he sido invocado $position")

        }

        if(position == 10){
            Log.i("johana","nombre: ${person.name} superPersona:${person.superUser}")
        }
    }
    //emisor
    fun setOnPersonClickListening(lambdaReceive: (Persona)->Unit){
        lambda =lambdaReceive

    }
}