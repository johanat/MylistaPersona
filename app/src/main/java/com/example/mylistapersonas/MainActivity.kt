package com.example.mylistapersonas

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylistapersonas.adapter.FirstFragment
import com.example.mylistapersonas.adapter.SecondFragment


class MainActivity : AppCompatActivity() {
    //  private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // de esta manera paso los valores a esta funcion  tanto valores simples como los lambdas
        //initRecyclerView()
        goToFirstFragment()
    }

    fun goToFirstFragment() {
        val bundle = Bundle()

        val firstFragment = FirstFragment()
        firstFragment.arguments = bundle

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, firstFragment).commit()
        }
    }
    fun goToSecondFragment(bundle: Bundle) {
        val secondFragment = SecondFragment()
         // recibe un bundle que le estan pasando y

        secondFragment.arguments = bundle
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, secondFragment).commit()
        }
    }
    fun myOnBackPressed(bundle: Bundle){
        if (Build.VERSION.SDK_INT <= 33) {

            onBackPressed()
        } else {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}




