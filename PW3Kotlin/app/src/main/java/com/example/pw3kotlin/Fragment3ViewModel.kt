package com.example.pw3kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment3ViewModel : ViewModel() {

    private val dataRepository = DataRepository()
    private val getDataUseCase = GetDataUseCase(dataRepository)

    val text: LiveData<String> = getDataUseCase.execute()

    fun updateText(newText: String) {
        (text as MutableLiveData).value = newText
    }
}
