package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.rennan.adoptimize.databinding.ActivityCampanhasBinding

class CampanhasActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityCampanhasBinding.inflate(layoutInflater)
    }
    private val bancoDados by lazy{
        FirebaseFirestore.getInstance()
    }
    private val autenticacao by lazy{
        FirebaseAuth.getInstance()
    }
    override fun onStart() {
        super.onStart()
        listarDados()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editListar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnVoltarCampanhas.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
    private fun listarDados(){
        val idUsuarioLogado = autenticacao.currentUser?.uid

        if(idUsuarioLogado!=null) {
            bancoDados
                .collection("campanhas")
                .addSnapshotListener { querySnapshot, error ->
                    val listaDocs = querySnapshot?.documents

                    var listaResultado = ""
                    listaDocs?.forEach { documentoSnapshot ->
                        val dados = documentoSnapshot?.data
                        if (dados != null) {
                            val nomeCampanha = dados["nome"]
                            val cliques = dados["cliques"]
                            val visualizacoes = dados["visualizações"]

                            listaResultado = "Nome: $nomeCampanha " +
                                    "\nCliques: $cliques" +
                                    "\nvisualizações: $visualizacoes \n \n"
                        }
                    }
                    binding.textViewLista.text = listaResultado
                }
        }
    }

}