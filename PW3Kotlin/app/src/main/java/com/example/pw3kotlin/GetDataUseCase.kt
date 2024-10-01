package com.example.pw3kotlin

import androidx.lifecycle.LiveData

class GetDataUseCase(private val dataRepository: DataRepository) {

    // Получение данных через репозиторий
    fun execute(): LiveData<String> {
        return dataRepository.getData()
    }
}
