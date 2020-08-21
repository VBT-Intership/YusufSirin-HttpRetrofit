package com.srn.kotlinhttpreq

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClient{
    private const val baseUrlString: String="https://rent-a-car-5911f.firebaseio.com/"
    val getClient: IHttpCar
        get() {
            val gson = GsonBuilder()
                .setLenient().create()
            val client =OkHttpClient.Builder().build()
            val retrofit= Retrofit.Builder()
                .baseUrl(baseUrlString)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(IHttpCar::class.java)

        }
}