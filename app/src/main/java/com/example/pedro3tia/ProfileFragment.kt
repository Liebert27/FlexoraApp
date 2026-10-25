package com.example.pedro3tia.Profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pedro3tia.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val dataListWithDesc = listOf(
        mapOf("title" to "Tentang Aplikasi", "desc" to "Home Workout Assistant, olahraga di rumah tanpa alat khusus"),
        mapOf("title" to "Target Latihan", "desc" to "3 kali dalam seminggu"),
        mapOf("title" to "Pengingat Latihan", "desc" to "Setiap hari pukul 07.00"),
        mapOf("title" to "Tingkat Kesulitan", "desc" to "Pemula"),
        mapOf("title" to "Bantuan", "desc" to "Pertanyaan yang sering diajukan"),
        mapOf("title" to "Versi Aplikasi", "desc" to "1.0")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil username yang disimpan saat login
        val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        binding.txtUsername.text = "Halo, $username"

        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"), // key yang diambil dari data
            intArrayOf(android.R.id.text1, android.R.id.text2) // tempat tampilnya
        )
        binding.listViewItems.adapter = adapter
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}