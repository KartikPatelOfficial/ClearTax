package com.deucate.cleartax

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.sql.Timestamp

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (!ConnectionChecker(this).conavailable()){

        }

        val recyclerView = findViewById<RecyclerView>(R.id.homeRecyclerView)
        val tweets = ArrayList<Tweet>()
        val adapter = HomeAdapter(tweets)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val result = GetTweets().execute().get()
        val latestTweets = ArrayList<Tweet>()
        latestTweets.add(Tweet(result!![0].user.profileImageURL,result[0].user.name,result[0].text,result[0].createdAt as Timestamp))
        latestTweets.add(Tweet(result[1].user.profileImageURL,result[1].user.name,result[1].text,result[1].createdAt as Timestamp))
        latestTweets.add(Tweet(result[2].user.profileImageURL,result[2].user.name,result[2].text,result[2].createdAt as Timestamp))


        for(i in 0 until result.size){
            val tweet = Tweet(result[i].user.profileImageURL,result[i].user.name+" . @"+result[i].user.screenName,result[i].text)
            tweets.add(tweet)
        }
        adapter.notifyDataSetChanged()
    }

}
