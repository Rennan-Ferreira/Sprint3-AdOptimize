package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExplicacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explicacao)
        val btnMudarPagina: Button = findViewById(R.id.btnp3)

        // Configurando o clique no botão
        btnMudarPagina.setOnClickListener {
            // Criando um Intent para iniciar a nova Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Iniciando a nova Activity
        }
    }
}