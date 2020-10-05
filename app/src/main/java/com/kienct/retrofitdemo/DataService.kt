package com.kienct.retrofitdemo

import retrofit2.Call
import retrofit2.http.*

interface DataService {
    @GET("api/users?")
    fun getData(@Query("page") page: String): Call<DataResponse>

    @POST("api/users")
    fun createUser(@Body user: User): Call<DataResponse>

    @PUT("api/users/2")
    fun editUser(@Body user: User): Call<DataResponse>
}