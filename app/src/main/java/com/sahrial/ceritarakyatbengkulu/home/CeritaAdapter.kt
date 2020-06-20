package com.sahrial.ceritarakyatbengkulu.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sahrial.ceritarakyatbengkulu.R
import com.sahrial.ceritarakyatbengkulu.home.model.Cerita

class CeritaAdapter(private var data: List<Cerita>,
                    private val listener: (Cerita) -> Unit)
    : RecyclerView.Adapter<CeritaAdapter.LeagueViewHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.row_populer, parent, false)

        return LeagueViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.tv_title)
        private val tvAsal: TextView = view.findViewById(R.id.tv_asal_daerah)
        private val tvSee: TextView = view.findViewById(R.id.tv_see)

        private val tvImage: ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data: Cerita, listener: (Cerita) -> Unit, context : Context, position : Int) {

            tvTitle.text = data.judul
            tvAsal.text = data.asal
            tvSee.text = data.see.toString()

            Glide.with(context)
                .load(data.poster)
                .into(tvImage);

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}

