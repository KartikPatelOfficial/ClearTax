package com.deucate.cleartax

import android.annotation.SuppressLint
import android.os.AsyncTask
import twitter4j.*
import twitter4j.conf.ConfigurationBuilder



@SuppressLint("StaticFieldLeak")
class GetTweets : AsyncTask<Void, Void, MutableList<Status>?>() {

    override fun doInBackground(vararg p0: Void?): MutableList<twitter4j.Status>? {
        val cb = ConfigurationBuilder()
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("tHKlu2ILQCsp7iLCaRmkMKgkt")
                .setOAuthConsumerSecret("S82sXgqXRjGczW547uIyj0rkRDOQcEUfalGW7QqgkEmzHzAnjk")
                .setOAuthAccessToken("728479978573074435-sYcb2wXhlmD0i1i7m4DYBgK8XSFXGws")
                .setOAuthAccessTokenSecret("WnXWGlRh4OuQIvGtzXsnY7nXVbvWapWq8pPyzuYSH4u19").setAsyncNumThreads(100)
        val tf = TwitterFactory(cb.build())
        val twitter = tf.instance
        try {
            val query = Query("ClearTax").count(100)
            val result: QueryResult
            result = twitter.search(query)
            val tweets = result.tweets
            return tweets
        } catch (te: TwitterException) {
            te.printStackTrace()
            println("Failed to search tweets: " + te.errorMessage)
            System.exit(-1)
        }
        return null
    }

}