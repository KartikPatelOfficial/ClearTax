package com.deucate.cleartax

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.homeRecyclerView)
        val tweets = ArrayList<Tweet>()
        val adapter = HomeAdapter(tweets)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val result = GetTweets(this).execute().get()

        for(i in 0 until result!!.size){
            val tweet = Tweet(result[i].user.miniProfileImageURL,result[i].user.name,result[i].text)
            tweets.add(tweet)
        }
        adapter.notifyDataSetChanged()

    }
}
