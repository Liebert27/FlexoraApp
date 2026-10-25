package com.example.pedro3tia.Program

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pedro3tia.ProgramDetailActivity
import com.example.pedro3tia.databinding.FragmentProgramBinding

class ProgramFragment : Fragment() {
    private lateinit var binding: FragmentProgramBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ikon pencarian dari URL internet
        Glide.with(this)
            .load("https://img.icons8.com/ios/100/9AA5AE/search--v1.png")
            .into(binding.imgSearch)

        // Intent: ProgramFragment -> ProgramDetailActivity
        binding.cardCalisthenics.setOnClickListener {
            val intent = Intent(requireContext(), ProgramDetailActivity::class.java)
            startActivity(intent)
        }
    }
}