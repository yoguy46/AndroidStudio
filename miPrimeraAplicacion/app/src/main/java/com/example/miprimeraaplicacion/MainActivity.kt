package com.example.miprimeraaplicacion

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    private val TAG= "StateChange"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.i(TAG,"estoy en onCreate")
    }
    override fun onRestart(){
        super.onRestart()
        Log.i(TAG,"estoy en onRestart")

    }
    override fun onStart(){
        super.onStart()
        Log.i(TAG,"estoy en onStart")

    }
    override fun onResume(){
        super.onResume()
        Log.i(TAG,"estoy en onResume")

    }

    override fun onPause(){
        super.onPause()
        Log.i(TAG,"estoy en onSpause")
    }
    override fun onStop(){
        super.onStop()
        Log.i(TAG,"estoy en onStop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i(TAG,"estoy en onDestroy")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre","Alvaro")
        Log.i(TAG,"estoy en onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var mNombreReibido=savedInstanceState.getString("nombre").toString()
        Log.i(TAG,"el nombre recibido es $mNombreReibido")
    }
}