package com.example.coroutinesproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private val _textAndNumber = MutableLiveData<Pair<String, Long>>()
    val textAndNumber: LiveData<Pair<String, Long>> = _textAndNumber

    fun addName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val delay = Random.nextLong(1000, 10000)
            Thread.sleep(delay)
            _textAndNumber.postValue(Pair(name, delay))
        }
    }
}
