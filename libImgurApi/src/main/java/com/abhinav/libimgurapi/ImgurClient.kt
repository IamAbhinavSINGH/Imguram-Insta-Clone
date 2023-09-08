package com.abhinav.libimgurapi

import com.abhinav.libimgurapi.apis.ImgurAPIv3
import com.abhinav.libimgurapi.converters.EnumConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {

    const val API_KEY = "Insert Your API_KEY here"
    // TODO: This should not be placed here remove it when open sourcing this project

    private val HttpClinet : OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor{
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "Client-ID $API_KEY")
                    .build()
                it.proceed(request)
            }
            .build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .client(HttpClinet)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .baseUrl("https://api.imgur.com/3/")
            .build()

    }

    val api : ImgurAPIv3 by lazy {
        retrofit.create(ImgurAPIv3::class.java)
    }
}