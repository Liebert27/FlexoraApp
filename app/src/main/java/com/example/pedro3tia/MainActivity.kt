package com.example.pedro3tia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.pedro3tia.Home.HomeFragment
import com.example.pedro3tia.Profile.ProfileFragment
import com.example.pedro3tia.Program.ProgramFragment
import com.example.pedro3tia.Progress.ProgressFragment
import com.example.pedro3tia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, 0) // bottom = 0
            insets
        }

        // Logout dan hapus status login
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Ya") { dialog, _ ->
                    getSharedPreferences("user_pref", MODE_PRIVATE)
                        .edit().clear().apply()

                    dialog.dismiss()
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .show()
        }

        // Fragment pertama yang tampil
        replaceFragment(HomeFragment())

        // Bottom Navigation
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.program -> {
                    replaceFragment(ProgramFragment())
                    true
                }
                R.id.progress -> {
                    replaceFragment(ProgressFragment())
                    true
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false // false jika item tidak dikenal
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}