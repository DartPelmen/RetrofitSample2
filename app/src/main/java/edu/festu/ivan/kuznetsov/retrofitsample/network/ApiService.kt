package edu.festu.ivan.kuznetsov.retrofitsample.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{lang}/API/Search/k_s9z75hs9/{expression}")
    fun getMovies(@Path(value = "lang")lang: String, @Path(value = "expression") expression: String): Call<SearchRequest>
}
