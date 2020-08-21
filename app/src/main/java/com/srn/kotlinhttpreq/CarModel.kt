package com.srn.kotlinhttpreq


import com.google.gson.annotations.SerializedName

data class  CarModel(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("price")
    val price: String = ""
)