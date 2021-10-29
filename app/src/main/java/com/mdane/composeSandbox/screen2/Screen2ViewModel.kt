package com.mdane.composeSandbox.screen2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class Screen2ViewModel: ViewModel() {

    private val _title: MutableSharedFlow<String> = MutableStateFlow("Screen 2")
    val title: Flow<String> = _title
        //.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "title1")

    init {
        viewModelScope.launch {
            for(i in 1 .. 5) {
                _title.emit("Screen 2: title $i")
                delay(2000)
            }
        }
    }
}