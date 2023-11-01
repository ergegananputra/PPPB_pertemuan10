package com.latihanbyrg.tugaspertemuan10

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.latihanbyrg.tugaspertemuan10.databinding.ItemMahasiswaBinding

typealias OnClickMahasiswa = (Mahasiswa) -> Unit

class MahasiswaAdapter(
    private val listMahasiswa: List<Mahasiswa>,
    private val onClickMahasiswa: OnClickMahasiswa
) : RecyclerView.Adapter<MahasiswaAdapter.itemMahasiswaViewHolder>() {

    inner class itemMahasiswaViewHolder(
        private val binding: ItemMahasiswaBinding
    ) : RecyclerView.ViewHolder(binding.root)
    {

        fun bind(data: Mahasiswa) {
            with(binding) {
                tvNama.text = data.name
                tvNim.text = data.nim
                ivMahasiswa.setImageResource(data.drawableId)
                tvNilaiIpk.text = data.ipk.toString()
                if (data.ipk >= 3.8) {
                    tvNilaiIpk.setTextColor(Color.parseColor("#0658E4"))
                } else if (data.ipk >= 3.5) {
                    tvNilaiIpk.setTextColor(Color.parseColor("#008C44"))
                } else if (data.ipk >= 3.0) {
                    tvNilaiIpk.setTextColor(Color.parseColor("#FFC600"))
                } else {
                    tvNilaiIpk.setTextColor(Color.parseColor("#FF6D00"))
                }


                itemView.setOnClickListener {
                    onClickMahasiswa(data)
                }

            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemMahasiswaViewHolder {
        val binding = ItemMahasiswaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return itemMahasiswaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }

    override fun onBindViewHolder(holder: itemMahasiswaViewHolder, position: Int) {
        holder.bind(listMahasiswa[position])
    }


}