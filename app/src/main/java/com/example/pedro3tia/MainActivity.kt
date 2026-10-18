
package com.example.pedro3tia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
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
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
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

        //  ikon dari URL internet
        fun loadIcon(view: ImageView, url: String) {
            Glide.with(this).load(url).into(view)
        }

        loadIcon(binding.imgSearch,
            "https://img.icons8.com/ios/100/9AA5AE/search--v1.png")
        loadIcon(binding.imgFocusStrength,
            "https://img.icons8.com/ios/100/B7F34A/dumbbell.png")
        loadIcon(binding.imgFocusFlex,
            "https://img.icons8.com/ios/100/B7F34A/stretching.png")
        loadIcon(binding.imgFocusCore,
            "https://img.icons8.com/ios/100/B7F34A/balance.png")

        loadIcon(binding.imgNavHome,
            "https://img.icons8.com/ios-filled/100/B7F34A/home.png")
        loadIcon(binding.imgNavProgram,
            "https://img.icons8.com/ios/100/9AA5AE/dumbbell.png")
        loadIcon(binding.imgNavProgress,
            "https://img.icons8.com/ios/100/9AA5AE/combo-chart.png")
        loadIcon(binding.imgNavProfile,
            "https://img.icons8.com/ios/100/9AA5AE/user.png")

    }
}
