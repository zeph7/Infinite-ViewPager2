package com.example.infiniteviewpager2.infinite_view_pager

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.infiniteviewpager2.R

class NormalRecyclerAdapter(var originalList: List<Sample>)
    : RecyclerView.Adapter<NormalRecyclerAdapter.NormalRecyclerViewHolder>() {

    class NormalRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(sample: Sample) {
            val pagerTextView: TextView = itemView.findViewById(R.id.pagerTextView)
            val pagerCardView: CardView = itemView.findViewById(R.id.pagerCardView)

            pagerTextView.text = sample.number.toString()
            pagerCardView.setBackgroundColor(Color.parseColor(sample.color))
        }

        companion object {
            fun from(parent: ViewGroup) : NormalRecyclerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemView = layoutInflater.inflate(R.layout.custom_infinite_pager_layout,
                    parent, false)
                return NormalRecyclerViewHolder(itemView)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalRecyclerViewHolder {
        return NormalRecyclerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NormalRecyclerViewHolder, position: Int) {
        holder.bind(originalList[position])
    }

    override fun getItemCount(): Int {
        return originalList.size
    }

}