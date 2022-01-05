package edu.festu.yulia.ponomarchuk.retrofitsample.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkSingleton {
    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://imdb-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun get():Retrofit = retrofit
}