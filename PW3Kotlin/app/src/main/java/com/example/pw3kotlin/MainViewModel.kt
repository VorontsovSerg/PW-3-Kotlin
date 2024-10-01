package com.example.pw3kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _fragmentText = MutableLiveData<String>().apply {
        value = "Initial Text"
    }
    val fragmentText: LiveData<String> = _fragmentText

    fun updateText(newText: String) {
        _fragmentText.value = newText
    }
}
