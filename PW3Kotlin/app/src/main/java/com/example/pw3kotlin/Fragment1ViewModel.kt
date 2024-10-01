package com.example.pw3kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment1ViewModel : ViewModel() {

    private val dataRepository = DataRepository()  // Создаем экземпляр репозитория
    private val getDataUseCase = GetDataUseCase(dataRepository)  // Инициализируем UseCase

    val text: LiveData<String> = getDataUseCase.execute()

    // Метод для обновления данных
    fun updateText(newText: String) {
        (text as MutableLiveData).value = newText
    }
}
