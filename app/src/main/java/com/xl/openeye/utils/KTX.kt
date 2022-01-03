package com.xl.openeye.utils

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment

/**
 * goActivity(MainActivity::class.java, ("index" to 0))
 */
fun Activity.goActivity(clazz: Class<*>) {
    this.startActivity(Intent(this, clazz))
}

fun Activity.goActivity(clazz: Class<Activity>, vararg pairs: Pair<String, Any>) {
    val intent = Intent(this, clazz)
    pairs.forEach { (key, value) ->
        if (value is String)
            intent.putExtra(key, value)
        if (value is Int)
            intent.putExtra(key, value)
        if (value is Boolean)
            intent.putExtra(key, value)
    }
    this.startActivity(intent)
}


fun Fragment.goActivity(clazz: Class<*>) {
    this.startActivity(Intent(activity, clazz))
}

fun Fragment.goActivity(clazz: Class<Activity>, vararg pairs: Pair<String, Any>) {
    val intent = Intent(activity, clazz)
    pairs.forEach { (key, value) ->
        if (value is String)
            intent.putExtra(key, value)
        if (value is Int)
            intent.putExtra(key, value)
        if (value is Boolean)
            intent.putExtra(key, value)
    }
    this.startActivity(intent)
}

