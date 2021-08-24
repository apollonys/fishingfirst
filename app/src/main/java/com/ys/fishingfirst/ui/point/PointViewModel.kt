package com.ys.fishingfirst.ui.point

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PointViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Point 공사중"
    }
    val text: LiveData<String> = _text
}