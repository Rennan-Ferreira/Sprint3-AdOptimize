package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class QuemSomosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quem_somos)

        val imgVoltarQ: ImageView = findViewById(R.id.imgVoltarQuemSomos)

        // Configurando o clique no botão
        imgVoltarQ.setOnClickListener {
            // Criando um Intent para iniciar a nova Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Iniciando a nova Activity
        }

        val integrantes = mapOf(
            "Rennan Ferreira" to "RM99364",
            "Jaisy Cibele" to "RM552269",
            "Tomaz Pecoraro" to "RM98499",
            "Luiz Felipe Camargo" to "RM552475",
            "Gabriel Amâncio" to "RM97936"
        )

        // Converta o Map para uma lista de strings
        val listaDeIntegrantes = integrantes.map { (nome, rm) -> "$nome - $rm" }

        val listaIntegrantes: ListView = findViewById(R.id.ListViewIntegrantes)

        // Use a lista convertida para o ArrayAdapter
        listaIntegrantes.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaDeIntegrantes
        )
    }
}
