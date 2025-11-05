package com.example.permisostiempoejecucion

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var boton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //bind
        boton = findViewById(R.id.boton)




        // Listener del botón
        boton.setOnClickListener {
            if (tenemosPermiso(Manifest.permission.CALL_PHONE)) {
                realizarLlamada()
            } else {
                solicitarPermiso(Manifest.permission.CALL_PHONE)
            }
        }
    }




    private fun tenemosPermiso(permiso: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permiso) == PackageManager.PERMISSION_GRANTED
    }


    /**
     * Indica el permiso que queremos solicitar y quién es el responsable de gestionar la solicitud
     * de permisos en tiempo de ejecución.
     *
     * @param permiso El permiso a solicitar (ej: Manifest.permission.CAMERA).
     */
    private fun solicitarPermiso(permiso: String) {
        //Aquí, this indica quien es el responsable de gestionar la solicitud de permisos y requestCode es un identifficador para nosotros
        ActivityCompat.requestPermissions(this, arrayOf(permiso), 1)
    }




    private fun realizarLlamada() {
        val numeroTelefono = "tel:112" // Número de teléfono a llamar
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = numeroTelefono.toUri()
        startActivity(intent)
    }


    /**
     * Metodo de callback invocado cuando el usuario responde a un diálogo de solicitud de permisos
     * iniciado por ActivityCompat.requestPermissions.
     *
     * Se utiliza para determinar si el permiso fue concedido o denegado,
     * basándose en el código de solicitud único (requestCode).
     *
     * @param requestCode El código de solicitud (entero) pasado originalmente a
     * requestPermissions(). Usado aquí para identificar la solicitud.
     * @param permissions La lista de permisos solicitados. Nunca es nula.
     * @param grantResults Los resultados de la concesión (GRANTED o DENIED)
     * correspondientes a los permisos. Nunca es nula.
     * PERMISSION_GRANTED = 0, PERMISSION_DENIED = -1.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                realizarLlamada()
            } else {
                Toast.makeText(this, "Permiso de llamada denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
