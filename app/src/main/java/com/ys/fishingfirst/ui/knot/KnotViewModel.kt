package com.ys.fishingfirst.ui.knot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KnotViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "매듭법 작성"
    }
    val text: LiveData<String> = _text
}