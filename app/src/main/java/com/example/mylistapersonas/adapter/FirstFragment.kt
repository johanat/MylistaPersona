package com.example.mylistapersonas.adapter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistapersonas.AttributesPersonasProvide
import com.example.mylistapersonas.MainActivity
import com.example.mylistapersonas.Persona
import com.example.mylistapersonas.R


class FirstFragment : Fragment(R.layout.fragment_first) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerPersonas)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        val adapter = PersonasAdapter(AttributesPersonasProvide.listPerson)
        recyclerView?.adapter = adapter

        adapter.setOnPersonClickListening { persona ->
            val bundle = Bundle()
            //aqui estoy pasando el bandle del tipo que quiero para hacer uso al otro fragment
            bundle.putSerializable("persona",persona)
            (activity as MainActivity).goToSecondFragment(bundle)

        }
    }
}