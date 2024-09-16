package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RelatorioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relatorio)
        val imgVoltarR: ImageView = findViewById(R.id.imgVoltarRelatorios)

        // Configurando o clique no botão
        imgVoltarR.setOnClickListener {
            // Criando um Intent para iniciar a nova Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Iniciando a nova Activity
        }
    }
}