package com.example.pedro3tia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pedro3tia.databinding.ActivityProgramDetailBinding

class ProgramDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProgramDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityProgramDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Kembali ke halaman Program
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Tombol Mulai Latihan (fitur latihan belum dibuat)
        binding.btnMulaiLatihan.setOnClickListener {
            Toast.makeText(this, "Fitur latihan segera hadir", Toast.LENGTH_SHORT).show()
        }
    }
}