package com.sklagat46.driveit.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sklagat46.driveit.BuildConfig
import com.sklagat46.driveit.data.local.Settings
import com.sklagat46.driveit.remote.Exclude
import com.sklagat46.driveit.utils.DateDeserializer
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * createNetworkClient
 */
fun createNetworkClient(
    baseUrl: String,
    settings: Settings
) =
    retrofitClient(httpClient(settings), baseUrl, provideGson())

private class BasicAuthInterceptor(val settings: Settings) : okhttp3.Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: okhttp3.Interceptor.Chain): okhttp3.Response {
        val requestBuilder = chain.request().newBuilder()
        val response: okhttp3.Response
        //appendHeaders(requestBuilder, settings)
        val request: okhttp3.Request = requestBuilder.build()
        response = chain.proceed(request)
        if (response.code() == 401) {
            ///logoutUser(settings)
        }

        return response
    }

}

/**
 * httpClient
 */
fun httpClient(settings: Settings): okhttp3.OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val clientBuilder = okhttp3.OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLoggingInterceptor)
    }
    clientBuilder.addInterceptor(BasicAuthInterceptor(settings))
    clientBuilder.readTimeout(120, TimeUnit.SECONDS)
    clientBuilder.writeTimeout(120, TimeUnit.SECONDS)

    return clientBuilder.build()
}



private fun retrofitClient(okHttpClient: okhttp3.OkHttpClient, baseUrl: String, gson: Gson): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()



//private fun appendHeaders(requestBuilder: okhttp3.Request.Builder, settings: Settings) {
//    try {
//        if (settings.getAuth() != null && settings.getAuth()?.token != null) {
//            requestBuilder.header(
//                "Authorization",
//                "Bearer " + settings.getAuth()?.token?.access_token
//            )
//        }
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//
//}

/**
 * provideGson
 */
fun provideGson(): Gson {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.addSerializationExclusionStrategy(Exclude())
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    gsonBuilder.registerTypeAdapter(
        Date::class.java,
        DateDeserializer()
    )
    return gsonBuilder.create()
}