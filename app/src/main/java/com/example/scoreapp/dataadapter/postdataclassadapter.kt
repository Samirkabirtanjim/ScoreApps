package com.example.scoreapp.dataadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scoreapp.R

// Data class representing the data for each item in the RecyclerView


class PostDataClassAdapter(private var dataList: ArrayList<postdataclass>) : RecyclerView.Adapter<PostDataClassAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var newsChannel: ImageView = itemView.findViewById(R.id.newschannel)
        var newsChannelName: TextView = itemView.findViewById(R.id.newschannelname)
        var playerImage: ImageView = itemView.findViewById(R.id.playerimages)
        var postTitle: TextView = itemView.findViewById(R.id.posttitle)
        var postDescription: TextView = itemView.findViewById(R.id.postdescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newslayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.newsChannel.setImageResource(data.newschannel)  // Set image resource for news channel
        holder.newsChannelName.text = data.newschannelname      // Set text for news channel name
        holder.playerImage.setImageResource(data.playerimages)  // Set image resource for player
        holder.postTitle.text = data.posttitle                  // Set text for post title
        holder.postDescription.text = data.postdescription     // Set text for post description
    }
}
