package com.example.android.dogsgallery.ui.overview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.dogsgallery.R
import com.squareup.picasso.Picasso

class DogsAdapter(private val context: Context,
private val listener:OnItemClick)
    : RecyclerView.Adapter<DogsAdapter.DogsViewHolder>() {

    var dogsList:List<String> = emptyList()

    class DogsViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val dogImage:ImageView = view.findViewById(R.id.iv_dog)
        val dogName:TextView = view.findViewById(R.id.tv_dog_name)
        val dogDescription:TextView = view.findViewById(R.id.tv_dog_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent,false)
        return DogsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val item = dogsList[position]
        holder.dogName.text = "Dog ${position+1}"
        holder.dogDescription.setText(R.string.really_cute_dog)
        Picasso.get()
            .load(item)
            .fit()
            .centerCrop()
            .into(holder.dogImage)

        holder.itemView.setOnClickListener {
            listener.onItemClickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return dogsList.size
    }

    interface OnItemClick{
        fun onItemClickListener(position: Int)
    }

}