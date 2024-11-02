package com.rennan.adoptimize

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.rennan.adoptimize.databinding.ActivityEsqueceuSenhaBinding

class EsqueceuSenhaActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityEsqueceuSenhaBinding.inflate(layoutInflater)
    }
    private val autenticacao by lazy{
        FirebaseAuth.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_esqueceu_senha)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editListar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.button2.setOnClickListener{
            esqueceuSenha()
        }

    }
    private fun esqueceuSenha(){
        val email = binding.editTextText.text.toString()
        autenticacao.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                AlertDialog.Builder(this)
                    .setTitle("Sucesso")
                    .setMessage("Enviado e-mail de redefinição")
                    .setNegativeButton("OK"){dialog,posicao->}
                    .create()
                    .show()
            }
            .addOnFailureListener{
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Não foi possível enviar e-mail de redefinição")
                    .setNegativeButton("OK"){dialog,posicao->}
                    .create()
                    .show()
            }
    }
}