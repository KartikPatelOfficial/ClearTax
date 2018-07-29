package com.deucate.cleartax

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class HomeAdapter(val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.main_recycler_layout, parent,false))
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val tweet = tweets[position]
        holder.profileNameTV.text = tweet.username
        holder.tweetTV.text = tweet.tweet
        Picasso.get().load(Uri.parse(tweet.profilePicURL)).into(holder.profilePictureIV)
    }

}

class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
    val profileNameTV = view.findViewById<TextView>(R.id.recyclerUsername)
    val tweetTV = view.findViewById<TextView>(R.id.recyclerTweets)
    val profilePictureIV = view.findViewById<ImageView>(R.id.recyclerProfilePicture)
}