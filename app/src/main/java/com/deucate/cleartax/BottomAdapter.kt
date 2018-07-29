package com.deucate.cleartax

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class BottomAdapter(val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<ViewholderBottom>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewholderBottom {
        return ViewholderBottom(LayoutInflater.from(parent.context).inflate(R.layout.recycler_bottom_sheet, parent, false))
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    override fun onBindViewHolder(holder: ViewholderBottom, position: Int) {
        val tweet = tweets[position]

        holder.profileNameTV.text = tweet.username
        holder.tweetTV.text = tweet.tweet
        Picasso.get().load(Uri.parse(tweet.profilePicURL)).into(holder.profilePictureIV)
    }

}

class ViewholderBottom(view: View) : RecyclerView.ViewHolder(view) {
    val profileNameTV = view.findViewById<TextView>(R.id.detailName)
    val tweetTV = view.findViewById<TextView>(R.id.detailText)
    val profilePictureIV = view.findViewById<CircleImageView>(R.id.detailImage)
}