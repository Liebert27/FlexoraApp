package com.example.pedro3tia.Progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pedro3tia.R
import com.example.pedro3tia.databinding.FragmentProgressBinding

class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!

    private val progressList = listOf(
        ProgressModel("Push-up", "Senin • 3 set • 12 repetisi", R.drawable.pushup),
        ProgressModel("Bodyweight Squat", "Selasa • 3 set • 15 repetisi", R.drawable.bodyweight_squat),
        ProgressModel("Plank", "Rabu • 3 set • 40 detik", R.drawable.plank),
        ProgressModel("Sit-up", "Kamis • 3 set • 15 repetisi", R.drawable.situp),
        ProgressModel("Jumping Jack", "Jumat • 3 set • 30 detik", R.drawable.jumping_jack),
        ProgressModel("Push-up", "Sabtu • 3 set • 12 repetisi", R.drawable.pushup),
        ProgressModel("Plank", "Minggu • 3 set • 40 detik", R.drawable.plank)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProgressAdapter(requireContext(), progressList)
        binding.listProgressItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}