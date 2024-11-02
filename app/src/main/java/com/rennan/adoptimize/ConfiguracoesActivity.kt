package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.rennan.adoptimize.databinding.ActivityCampanhasBinding
import com.rennan.adoptimize.databinding.ActivityConfiguracoesBinding

class ConfiguracoesActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityConfiguracoesBinding.inflate(layoutInflater)
    }
    private val autenticacao by lazy{
        FirebaseAuth.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.imgVoltarConfig.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }
        binding.btnSingOut.setOnClickListener{
            logoutUser()

            val intent = Intent(this, LogarActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun logoutUser() {
        FirebaseAuth.getInstance().signOut()
    }


}