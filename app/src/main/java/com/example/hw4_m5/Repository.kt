package com.example.hw4_m5

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    val api = RetrofitService.api
    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val love = MutableLiveData<LoveModel>()

        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        love.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure:${t.message}")
            }

        })
        return love
    }
}