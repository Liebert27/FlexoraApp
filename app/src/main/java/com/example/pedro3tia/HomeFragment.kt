package com.example.pedro3tia.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pedro3tia.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ikon dari URL internet
        fun loadIcon(target: ImageView, url: String) {
            Glide.with(this).load(url).into(target)
        }

        loadIcon(binding.imgSearch,
            "https://img.icons8.com/ios/100/9AA5AE/search--v1.png")
        loadIcon(binding.imgFocusStrength,
            "https://img.icons8.com/ios/100/B7F34A/dumbbell.png")
        loadIcon(binding.imgFocusFlex,
            "https://img.icons8.com/ios/100/B7F34A/stretching.png")
        loadIcon(binding.imgFocusCore,
            "https://img.icons8.com/ios/100/B7F34A/balance.png")
    }
}