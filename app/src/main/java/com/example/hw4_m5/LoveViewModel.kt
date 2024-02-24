package com.example.hw4_m5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class LoveViewModel : ViewModel() {
    val repository = Repository()
    fun getLiveLoveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }
}