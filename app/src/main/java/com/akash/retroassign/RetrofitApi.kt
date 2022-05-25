package com.akash.retroassign

import com.akash.retroassign.DataClass.CommitDetails
import com.akash.retroassign.DataClass.Commits
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.github.com/"

interface RetrofitApi {
    @GET("/repos/square/retrofit/commits")
    fun getCommits(): Call<List<Commits>>

    @GET("/repos/square/retrofit/commits/{sha}")
    fun getCommitDetails(@Path("sha") sha : String)  : Call<CommitDetails>
}

object RetrofitInstance{
    val retrofitInstance:RetrofitApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInstance = retrofit.create(RetrofitApi::class.java)
    }

}