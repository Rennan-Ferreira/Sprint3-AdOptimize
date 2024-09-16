package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnMudarPaginaQuemSomos: Button = findViewById(R.id.btnQuemSomos)
        val btnMudarPaginaRelatorios: Button = findViewById(R.id.btnRelatorios)

        // Configurando o clique no botão
        btnMudarPaginaQuemSomos.setOnClickListener {
            // Criando um Intent para iniciar a nova Activity
            val intent = Intent(this, QuemSomosActivity::class.java)
            startActivity(intent) // Iniciando a nova Activity
        }
        btnMudarPaginaRelatorios.setOnClickListener {
            // Criando um Intent para iniciar a nova Activity
            val intent = Intent(this, RelatorioActivity::class.java)
            startActivity(intent) // Iniciando a nova Activity
        }
    }
}