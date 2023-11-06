package com.example.tugasbuah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasbuah.databinding.ItemBuahBinding


typealias OnClickBuah = (Buah) -> Unit
class BuahAdapter(private val listBuah: List<Buah>,
    private val onClickBuah: OnClickBuah) :
    RecyclerView.Adapter<BuahAdapter.ItemBuahViewHolder>() {
    inner class ItemBuahViewHolder(private val binding: ItemBuahBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Buah) {
            with(binding) {
                imgIcon.setImageResource(data.imageResId)
                buahName.text = data.nama
                warnaTxt.text = data.warna

                itemView.setOnClickListener {
                    onClickBuah(data)

                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBuahViewHolder {
        val binding =ItemBuahBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ItemBuahViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: ItemBuahViewHolder, position: Int) {
        holder.bind(listBuah[position])
    }
}