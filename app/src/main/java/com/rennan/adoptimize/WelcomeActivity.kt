package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.rennan.adoptimize.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    private val autenticacao by lazy{
        FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        verificarUsuarioLogado()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnLogar.setOnClickListener{
            startActivity(Intent(this, LogarActivity::class.java))
        }

        binding.btnCadastrar.setOnClickListener{
            startActivity(Intent(this, CadastrarActivity::class.java))
        }


    }
    private fun verificarUsuarioLogado(){
        val usuario = autenticacao.currentUser
        //val id = autenticacao.currentUser?.uid

        if(usuario!=null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}