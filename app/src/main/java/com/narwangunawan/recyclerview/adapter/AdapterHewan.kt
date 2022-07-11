package com.narwangunawan.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.narwangunawan.recyclerview.databinding.ListItemHewanBinding
import com.narwangunawan.recyclerview.model.Hewan

class AdapterHewan (private val  context : Context,
                    private val data : List<Hewan>?,
                    private val itemclik : OnClickListener)
                    : RecyclerView.Adapter<AdapterHewan.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemHewanBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclik.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0


    inner class ViewHolder(val binding: ListItemHewanBinding) : RecyclerView.ViewHolder(binding.root) {
        val foto = binding.image
        val nama = binding.txtnama
    }
    interface OnClickListener {
        fun detailData(item : Hewan?)
    }
}