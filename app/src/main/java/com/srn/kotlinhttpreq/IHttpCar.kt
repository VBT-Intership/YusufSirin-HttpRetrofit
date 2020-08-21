package com.srn.kotlinhttpreq

import retrofit2.Call
import retrofit2.http.GET

interface  IHttpCar{
    @GET("cars.json")
    fun getHttpCarList(): Call<List<CarModel>>
}