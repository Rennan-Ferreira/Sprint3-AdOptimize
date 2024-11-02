package com.rennan.adoptimize

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rennan.adoptimize.databinding.ActivityCampanhasBinding
import com.rennan.adoptimize.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.btnQuemSomos.setOnClickListener {
            startActivity(Intent(this, QuemSomosActivity::class.java))
        }

        binding.btnRelatorios.setOnClickListener{
            startActivity(Intent(this, RelatorioActivity::class.java))
        }

        binding.btnCampanhas.setOnClickListener{
            startActivity(Intent(this, CampanhasActivity::class.java))
        }

        binding.btnConfiguracoes.setOnClickListener{
            startActivity(Intent(this, ConfiguracoesActivity::class.java))
        }
    }
}