package com.kienct.retrofitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setup retrofit
        val retrofit =
            Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(DataService::class.java)
        val call = service.editUser(user)//call any methods from DataService
//        val call = service.getData(page)
        call.enqueue(object : Callback<DataResponse> {
            override fun onResponse(
                call: Call<DataResponse>,
                response: Response<DataResponse>
            ) {
                when {
                    response.code() == 201 -> {//201 is for creating, 200 is for reading, updating
                        val dataResponse = response.body()!!
                        val userInfo = "Name: ${dataResponse.name}\n" +
                                "Job: ${dataResponse.job}\n" +
                                "ID: ${dataResponse.id}\n" +
                                "Created at: ${dataResponse.createdAt}"
                        tvTest!!.text = userInfo
                    }
                    response.code() == 200 -> {
                        val dataResponse = response.body()!!
                        val stringBuilder = "Name: ${dataResponse.name}\n" +
                                "Job: ${dataResponse.job}\n" +
                                "Updated at: ${dataResponse.updatedAt}"
//                            "Page: ${dataResponse.page}\n" +
//                                    "Per page: ${dataResponse.perPage}\n" +
//                                    "Total: ${dataResponse.total}\n" +
//                                    "Total Pages: ${dataResponse.totalPages}"
                        tvTest!!.text = stringBuilder
                    }
                    else -> tvTest!!.text = response.code().toString()//maybe error, usually 400 bad request
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {//if there is any exceptions
                tvTest!!.text = t.message
            }
        })
    }
//for calling
    companion object {
        var BaseUrl = "https://reqres.in/" //api source
        var user = User("KienCT", "Student")
        var page = "2"
        var email = "eve.holt@reqres.in"
        var password = "pistol"
        var AppId = "d32e7a416a5949ff289dc1fa3795f614"//this is of OpenWeather, unused
        var lat = "21"//latitude, unused
        var lon = "105"//longitude, unused
    }
}

