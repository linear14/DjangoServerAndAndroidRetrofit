package com.dongldh.movietestapp.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRetrofit {

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private fun okHttpClientBuilder(): OkHttpClient.Builder {
        val okhttpClientBuilder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        okhttpClientBuilder.addInterceptor(logging)

        return okhttpClientBuilder
    }

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://de99354583f0.ngrok.io/")
            //.baseUrl("http://127.0.0.1:8000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClientBuilder().build())
            .build()

    fun getService(): MovieRetrofitService = retrofit.create(MovieRetrofitService::class.java)
}