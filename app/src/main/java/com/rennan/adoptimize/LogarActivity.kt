package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.rennan.adoptimize.databinding.ActivityLogarBinding

class LogarActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityLogarBinding.inflate(layoutInflater)
    }

    private val autenticacao by lazy{
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_logar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editListar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnLogar.setOnClickListener{
            logarUsario()
        }
        binding.imgVoltarWelcome.setOnClickListener{
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
        binding.textViewEsqueceuSenha.setOnClickListener{
            startActivity(Intent(this, EsqueceuSenhaActivity::class.java))
        }
    }
    private fun logarUsario(){
        val email  = binding.editTextEmail.text.toString()
        val senha = binding.editTextSenha.text.toString()

        autenticacao.signInWithEmailAndPassword(email,senha)
            .addOnSuccessListener { authResult->
                startActivity(Intent(this,MainActivity::class.java))
            }
            .addOnFailureListener{exception->
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Verificar e-mail e senha digitados..")
                    .setNegativeButton("OK"){dialog,posicao->}
                    .create()
                    .show()
            }
    }
}