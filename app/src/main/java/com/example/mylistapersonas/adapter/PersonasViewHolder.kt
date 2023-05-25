package com.example.mylistapersonas.adapter

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mylistapersonas.Persona
import com.example.mylistapersonas.R



class PersonasViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    var lambda: ((Persona)->Unit)? = null
    val image = view.findViewById<ImageView>(R.id.ivPersona)
    val name = view.findViewById<TextView>(R.id.namePersona)
    val age = view.findViewById<TextView>(R.id.agePersona)
    val superPerson = view.findViewById<TextView>(R.id.superPersona)
    val switch = view.findViewById<Switch>(R.id.switch_Items)
    var hacerCaso = true

    fun setOnItemClicked(onItemClicked: (Persona)->Unit){
        lambda = onItemClicked
        // emisor
    }

    fun render(persona: Persona) {
        // itemView.setBackgroundColor(Color.YELLOW)
        // modifico con solo dar un click la imagen de persona y cambio de color
        Glide.with(image.context).load(persona.photo).into(image)

        itemView.setOnClickListener {
           // esta clase es la envia por que se envoca al lambda
            lambda?.invoke(persona)



           /* persona.selected = !persona.selected
            if (persona.selected) {
                Glide.with(image.context).load(R.drawable.dog).into(image)
                itemView.setBackgroundColor(Color.GREEN)
            } else {
                Glide.with(image.context).load(persona.photo).into(image)
                itemView.setBackgroundColor(Color.WHITE)
            }*/
        }
        name.text = persona.name
        age.text = persona.age.toString()
        superPerson.text = persona.superUser.toString()

       /* if (persona.selected) {
            Glide.with(image.context).load(R.drawable.dog).into(image)
            itemView.setBackgroundColor(Color.GREEN)

        } else {
            Glide.with(image.context).load(persona.photo).into(image)
            itemView.setBackgroundColor(Color.WHITE)
        }*/

       // Log.i("johana", "name=${name.text}, isBlue=${persona.isBlue}")
        if (persona.isBlue) {
            name.setTextColor(Color.BLUE)
        } else {
            name.setTextColor(Color.BLACK)
        }

        //log.i se utiliza para imprimir mensajes de registro
        // es util para depurar cualquier aplicacion

        image.setOnClickListener {
            persona.isBlue = !persona.isBlue
            if (persona.isBlue) {
                name.setTextColor(Color.BLUE)
            } else {
                name.setTextColor(Color.BLACK)
            }
        }
        superPerson.text = persona.superUser.toString()

        if (persona.superUser) {
            itemView.setBackgroundColor(Color.RED)
            if (!switch.isChecked) {
                hacerCaso = false
                switch.isChecked =true
            }
        }else{
            itemView.setBackgroundColor(Color.WHITE)
            if (switch.isChecked) {
                hacerCaso = false
                switch.isChecked =false
            }
        }
        switch.setOnCheckedChangeListener { X, colorVerde ->

            Log.i("johana","llamando call back")
            if (hacerCaso) {
                persona.superUser = colorVerde
                if (colorVerde){
                    itemView.setBackgroundColor(Color.RED)
                }else{
                    itemView.setBackgroundColor(Color.WHITE)
                }
                superPerson.text = persona.superUser.toString()
            }
            //Log.i("johana","3. hacer caso = true")
            hacerCaso = true
        }
    }
}

