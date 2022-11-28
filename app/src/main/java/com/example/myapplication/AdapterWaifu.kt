package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.ItemRowWaifuBinding

class AdapterWaifu(private val listWaifuAll: ArrayList<Waifu>) : RecyclerView.Adapter<AdapterWaifu.ViewHolder>() {

    private lateinit var vListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        vListener = listener
    }


    inner class ViewHolder (val binding: ItemRowWaifuBinding, listener: onItemClickListener) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.tvItemNameWaifu.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
            binding.tvItemDetailWaifu.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowWaifuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, vListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero_waifu = listWaifuAll[position]

        Glide.with(holder.binding.imgItemPhotoWaifu)
            .load(hero_waifu.photo_waifu)
            .apply(RequestOptions().override(98, 98))
            .into(holder.binding.imgItemPhotoWaifu)

        holder.binding.tvItemNameWaifu.text = hero_waifu.nama_waifu
        holder.binding.tvItemDetailWaifu.text = hero_waifu.detail_waifu

        Glide.with(holder.binding.fotoSenjata)
            .load(hero_waifu.photo_waifu)
            .apply(RequestOptions().override(1,1))
            .into(holder.binding.fotoSenjata)

        holder.binding.namaSenjata.text = hero_waifu.nama_senjata


    }

    override fun getItemCount(): Int {
        return listWaifuAll.size
    }


}