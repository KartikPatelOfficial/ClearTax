package com.deucate.cleartax

import java.sql.Timestamp

class Tweet(val profilePicURL:String, val username:String, val tweet:String, val time:Timestamp = Timestamp(1532890050 ))