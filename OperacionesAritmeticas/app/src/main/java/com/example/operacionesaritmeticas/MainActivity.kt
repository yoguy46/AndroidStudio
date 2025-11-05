package com.example.operacionesaritmeticas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var boton1: Button
    private lateinit var boton2: Button
    private lateinit var boton3: Button
    private lateinit var boton4: Button
    private lateinit var texto1: EditText
    private lateinit var texto2: EditText
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        enableEdgeToEdge()


        boton1 = findViewById(R.id.suma)
        boton2 = findViewById(R.id.resta)
        boton3 = findViewById(R.id.multiplicacion)
        boton4 = findViewById(R.id.division)
        texto1 = findViewById(R.id.caja1)
        texto2 = findViewById(R.id.caja2)
        resultado = findViewById(R.id.resultado)


        // le he añadido un listener para cuando clickes se borre el texto con el metodo clear
        texto1.setOnClickListener {
            texto1.text.clear()
        }
        texto2.setOnClickListener {
            texto2.text.clear()
        }
        boton1.setOnClickListener {
            val n1 = texto1.text.toString().toDouble()
            val n2 = texto2.text.toString().toDouble()
            resultado.text = (n1 + n2).toString()
        }

        boton2.setOnClickListener {
            val n1 = texto1.text.toString().toDouble()
            val n2 = texto2.text.toString().toDouble()
            resultado.text = (n1 - n2).toString()
        }

        boton3.setOnClickListener {
            val n1 = texto1.text.toString().toDouble()
            val n2 = texto2.text.toString().toDouble()
            resultado.text = (n1 * n2).toString()
        }

        boton4.setOnClickListener {
            val n1 = texto1.text.toString().toDouble()
            val n2 = texto2.text.toString().toDouble()
            if (n1 == null || n2 == null) {
                resultado.text = " solo se permite numero"
            } else if (n2 == 0.0) {
                resultado.text = "No se puede dividir entre 0"
            } else {
                resultado.text = (n1 / n2).toString()
            }
        }
    }
}
