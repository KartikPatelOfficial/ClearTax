package com.deucate.cleartax

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar = toolbar
        toolbar.title = "ClearTax"
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"))

        if (!ConnectionChecker(this).conavailable()){

        }

        val recyclerView = findViewById<RecyclerView>(R.id.homeRecyclerView)
        val bottomRecyclerView = findViewById<RecyclerView>(R.id.bottomRecyclerView)

        val tweets = ArrayList<Tweet>()
        val latestTweets = ArrayList<Tweet>()

        val adapter = HomeAdapter(tweets)
        val bottomAdapter = BottomAdapter(latestTweets,this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        bottomRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        recyclerView.adapter = adapter
        bottomRecyclerView.adapter = bottomAdapter

        val result = GetTweets().execute().get()
        latestTweets.add(Tweet(result!![0].user.biggerProfileImageURL,result[0].user.name,result[0].text,result[0].createdAt))
        latestTweets.add(Tweet(result[1].user.biggerProfileImageURL,result[1].user.name,result[1].text,result[1].createdAt))
        latestTweets.add(Tweet(result[2].user.biggerProfileImageURL,result[2].user.name,result[2].text,result[2].createdAt))

        for(i in 0 until result.size){
            val tweet = Tweet(result[i].user.profileImageURL,result[i].user.name+" . @"+result[i].user.screenName,result[i].text)
            tweets.add(tweet)
        }
        adapter.notifyDataSetChanged()
        bottomAdapter.notifyDataSetChanged()
    }


}
