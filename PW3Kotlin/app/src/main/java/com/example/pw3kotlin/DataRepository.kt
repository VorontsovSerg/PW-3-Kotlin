package com.example.pw3kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataRepository {

    // Метод для получения данных
    fun getData(): LiveData<String> {
        val liveData = MutableLiveData<String>()
        liveData.value = "Данные из репозитория"
        return liveData
    }
}
