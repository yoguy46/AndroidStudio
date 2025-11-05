package com.example.pruebasalvaro

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class Inicio : AppCompatActivity() {


    //declaramos todas las variables de tipo button
    private lateinit var botonAlmacen: Button
    private lateinit var botonPedidos: Button
    private lateinit var botonEventos: Button
    private lateinit var botonTaller: Button
    private lateinit var videoView: VideoView
    private lateinit var telefono: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        videoView = findViewById(R.id.videoBackground)
        botonAlmacen=findViewById(R.id.almacen)
        botonPedidos=findViewById(R.id.pedidos)
        botonEventos=findViewById(R.id.eventos)
        botonTaller=findViewById(R.id.taller)
        telefono=findViewById(R.id.llamar)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.fondo
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true   // Para que se repita
            mp.setVolume(0f, 0f)  // Opcional: silenciar
        }

        videoView.start()
        botonAlmacen.setOnClickListener {
            //le pasamos como parametros primero donde estamos(this) luego la clase y el tipo de clase a donde queremos ir)
            val intent1= Intent(this, Almacen::class.java)
            startActivity(intent1)

        }
        botonTaller.setOnClickListener {
            val intent1 = Intent(this, Taller::class.java)
            startActivity(intent1)

        }
        botonEventos.setOnClickListener {
            val intent1 = Intent(this, Eventos::class.java)
            startActivity(intent1)

        }
        botonPedidos.setOnClickListener {
            val intent1 = Intent(this, Pedidos::class.java)
            startActivity(intent1)
        }
        telefono.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = "tel:626002361".toUri()
            if (callIntent.resolveActivity(packageManager) != null) {
                startActivity(callIntent)
            } else {
                Log.e("MainActivity", "No hay aplicación instalada para manejar la acción.")
            }
        }


    }
    override fun onResume() {
        super.onResume()
        videoView.start()
    }
    override fun onPause() {
        super.onPause()
        videoView.pause()
    }
}