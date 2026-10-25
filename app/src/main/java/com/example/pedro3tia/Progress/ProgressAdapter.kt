package com.example.pedro3tia.Progress

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pedro3tia.databinding.ItemProgressBinding

class ProgressAdapter(
    context: Context,
    private val items: List<ProgressModel>
) : ArrayAdapter<ProgressModel>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemProgressBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = items[position]

        // Tampilkan data ke layout item
        binding.imgGerakan.setImageResource(data.gambar)
        binding.txtNamaGerakan.text = data.namaGerakan
        binding.txtKeterangan.text = data.keterangan

        view.setOnClickListener {
            Toast.makeText(
                context,
                "${data.namaGerakan}: ${data.keterangan}",
                Toast.LENGTH_SHORT
            ).show()
        }
        return view
    }
}