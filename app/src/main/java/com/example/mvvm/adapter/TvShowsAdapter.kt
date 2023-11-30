package com.example.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import com.example.mvvm.R
import com.example.mvvm.model.TvShowItem

class TvShowsAdapter(val tvShows: List<TvShowItem>,val context: Context) : Adapter<TvShowsAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.img)
        val txt: TextView = itemView.findViewById(R.id.txt)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tv_shows, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TvShowsAdapter.ViewHolder, position: Int) {

        holder.txt.text = tvShows[position].name

        holder.img.load(tvShows[position].image.original) {
            crossfade(true)
            crossfade(1000)
        }
    }

    override fun getItemCount(): Int = tvShows.size

}