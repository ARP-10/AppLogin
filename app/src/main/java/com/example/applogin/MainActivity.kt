package com.example.applogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.RadioButton
import com.example.applogin.databinding.ActivityMainBinding
import com.example.applogin.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener(this)
        binding.botonLimpiar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.botonLimpiar.id -> {
                if (!binding.editPassword.text.isEmpty() || !binding.editCorreo.text.isEmpty()) {
                    val correo = binding.editCorreo.text.clear()
                    val password = binding.editPassword.text.clear()
                }
            }

            binding.botonLogin.id -> {
                // Comprobar campos
                if (!binding.editPassword.text.isEmpty() && !binding.editCorreo.text.isEmpty() && findViewById<RadioButton>(binding.grupoBotonPerfil.checkedRadioButtonId).text.toString() != null ) {
                    val correo = binding.editCorreo.text.toString()
                    val password = binding.editPassword.text.toString()
                    val perfil = binding.spinnerPerfil.selectedItem.toString()
                    val visibilidad = findViewById<RadioButton>(binding.grupoBotonPerfil.checkedRadioButtonId).text.toString()

                    // Cambiar de pantalla -> action INTENT
                    val intent: Intent = Intent(applicationContext, SecondActivity::class.java) // application context es lo mismo que poner "this", es la pantalla donde estamos
                    // Asociar clave-valor
                    intent.putExtra("usuario", Usuario(correo, password, perfil, visibilidad))
                    startActivity(intent)

                } else {
                    Snackbar.make(
                        binding.root,
                        resources.getString(R.string.mensaje_datos),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }
}