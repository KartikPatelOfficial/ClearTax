package com.deucate.cleartax

import android.content.Context
import android.net.NetworkInfo
import android.net.ConnectivityManager



class ConnectionChecker(val context:Context){

    fun conavailable():Boolean{

        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (true) {
            val info = connectivity.allNetworkInfo
            if (info != null)
                for (i in info.indices)
                    if (info[i].state == NetworkInfo.State.CONNECTED) {
                        return true
                    }

        }

        return false
    }

}