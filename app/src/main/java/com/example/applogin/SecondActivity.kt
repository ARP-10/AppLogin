package com.example.applogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applogin.databinding.ActivityMainBinding
import com.example.applogin.databinding.ActivitySecondBinding
import com.example.applogin.model.Usuario

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var usuarioRecuperado: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarioRecuperado = intent.extras!!.getSerializable("usuario") as Usuario
        binding.textoUsuario.text = usuarioRecuperado.correo

        binding.botonLogout.setOnClickListener {
            finish()
        }


    }
}