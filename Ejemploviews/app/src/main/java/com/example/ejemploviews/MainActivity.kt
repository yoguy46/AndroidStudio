package com.example.ejemploviews

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {


    private lateinit var primEtiq: TextView
    private lateinit var editTextNumber: EditText
    private lateinit var boton: Button
    private lateinit var logo: ImageView
    private lateinit var radioGroup: RadioGroup
    private lateinit var rbSeleccionado: RadioButton
    private lateinit var botonRG:Button
    private lateinit var btnSwitch: MaterialSwitch



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bind
       // radioGroup=findViewById(R.id.radioGroup)
        botonRG=findViewById(R.id.button2)
        editTextNumber=findViewById(R.id.etEjemplo)
        primEtiq = findViewById(R.id.main_etiqueta1)
        primEtiq.setText("He modificado mi etiqueta")
        boton=findViewById(R.id.button2)
        val number=4
        btnSwitch=findViewById(R.id.btnSwitch)
      //  logo=findViewById(R.id.imageView)

        btnSwitch.setOnClickListener {

        }
       /* botonRG.setOnClickListener {

            val id_rb:Int=radioGroup.checkedRadioButtonId
            rbSeleccionado=findViewById(id_rb)
            Log.d("radio group",rbSeleccionado.text.toString())
        }

*/


//imageView
      /*  logo=findViewById(R.id.imageView)
        logo.setOnTouchListener { v: View, m: MotionEvent ->
            val action = m.action
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    Log.d("MainActivity", "Down")
                }
                MotionEvent.ACTION_MOVE -> {
                    Log.d("MainActivity", "Move")
                }
                MotionEvent.ACTION_UP -> {
                    Log.d("MainActivity", "Up")
                }
            }
            true
        }
        //boton
        boton.setOnClickListener {
            Log.d("boton","boton pulsado")
            Toast.makeText(this,"texto a mostrar", Toast.LENGTH_SHORT).show()
        }
*/



      /*  editTextNumber.setText(number.toString())
        editTextNumber.addTextChangedListener(object : TextWatcher {


            override fun afterTextChanged(s: Editable) {


                Log.i("edittext", "after "+s)
            }


            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
                Log.i("edittext", String.format("before %s", s))
            }


            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Log.i("edittext", String.format("ontext %s", s))
            }
        })
*/
    }

}
