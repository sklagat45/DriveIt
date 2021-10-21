package com.sklagat46.driveit.utils

import android.Manifest

internal class Constants {
    companion object {
        const val SPLASH_SLEEP_TIME: Long = 2000
        const val SLEEP_TIME: Long = 1000
        const val BASE_URL_STAGING = "https://reqres.in/"
        const val BASE_URL_RELEASE = "https://reqres.in/"
        /* TimeFormat*/
        val RETROFIT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
        val SIMPLE_DATETIME_FORMAT = "YYYY-MM-DD HH:MM"
        val SIMPLE_TIME_FORMAT = "hh:mm a"
        val SIMPLE_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
        val SIMPLE_DATE_TIME_FORMAT_NO_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss"
        val SIMPLE_DATE_TIME_FORMAT_WITH_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'"
        val SIMPLE_DATE_TIME_MS_FORMAT_WITH_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ"
        val SIMPLE_DATE_TIME_FORMAT_READABLE = "EEE, d MMM hh:mm a"
        val SIMPLE_DATE_TIME_FORMAT_READABLE_YEAR = "EEE, d MMM yyyy"
        val SIMPLE_DATE_TIME_FORMAT_READABLE_DATE = "EEE, d MMM "
        const val SIMPLE_DATE_TIME_FORMAT_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ssZ"
        const val SIMPLE_DATE_TIME_MS_FORMAT_NO_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS"
        val SIMPLE_DATE_FORMAT = "yyyy-MM-dd"
        val YEAR_FORMAT = "yy"
        val TIME_FORMAT = "HHmmss"


    }
}