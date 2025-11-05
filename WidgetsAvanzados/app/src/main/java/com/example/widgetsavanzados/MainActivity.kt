package com.example.widgetsavanzados

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


        private lateinit var Spinner:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //bindeo
        Spinner=findViewById(R.id.spinner)

        //val datos=arrayOf("ele1","ele2","ele3")
        val adaptador= ArrayAdapter.createFromResource(this,R.array.valores_array,android.R.layout.simple_spinner_item)
        adaptador.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item))
        Spinner.adapter=adaptador

        Spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {


            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val pos = parent.getItemAtPosition(position)


                Toast.makeText(this@MainActivity, "se ha seleccionado $pos", Toast.LENGTH_SHORT).show()
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }
}