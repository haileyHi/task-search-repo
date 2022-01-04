package com.task.searchrepo.util

import java.sql.Timestamp
import java.text.SimpleDateFormat

class Convert {
    fun numToString(number: Int): String {
        return when (number) {
            in 0..999 -> "" + number
            in 1000..1000000 ->
                "" + (number / 1000) + "." + Math.round((number % 1000 / 100.0)) + "K"
            else -> "" + (number / 1000000) + "." + Math.round((number % 1000000 / 100000.0)) + "M"
        }
    }
    fun stringDateToFormat(date: String): String {
        val dateToTimestamp = date.substring(0,10) + " " + date.substring(11,19)
        // date = date.replace("T", " ")
        // date = date.replace("Z", "") -> Timestamp().valueOf(date)
        val sdf = SimpleDateFormat("EEE, MMM d, ''yy").format(Timestamp.valueOf(dateToTimestamp))
        return sdf
    }
}