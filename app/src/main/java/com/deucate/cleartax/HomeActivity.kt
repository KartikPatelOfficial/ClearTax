package com.deucate.cleartax

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import twitter4j.*

import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterException
import twitter4j.QueryResult
import twitter4j.TwitterFactory
import android.os.AsyncTask



class HomeActivity : AppCompatActivity() {

    var PREFERENCE_NAME = "twitter_oauth"
    val PREF_KEY_OAUTH_TOKEN = "oauth_token"
    val PREF_KEY_OAUTH_SECRET = "oauth_token_secret"
    val PREF_KEY_TWITTER_LOGIN = "isTwitterLogedIn"

    val TWITTER_CALLBACK_URL = "oauth://t4jsample"

    val URL_TWITTER_AUTH = "auth_url"
    val URL_TWITTER_OAUTH_VERIFIER = "oauth_verifier"
    val URL_TWITTER_OAUTH_TOKEN = "oauth_token"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        SendfeedbackJob().execute("")

    }

    @SuppressLint("StaticFieldLeak")
    private inner class SendfeedbackJob : AsyncTask<String, Void, String>() {

        override fun doInBackground(params: Array<String>): String {
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
                for (tweet in tweets) {
                    Log.d("---->",tweet.text)
                }
            } catch (te: TwitterException) {
                te.printStackTrace()
                println("Failed to search tweets: " + te.errorMessage)
                System.exit(-1)
            }
            return "Hello"
        }

        override fun onPostExecute(message: String) {
        }
    }
}
