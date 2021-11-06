package com.mdane.composeSandbox.screen2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
/*
* Compose is the only cool and innovative thing that google has made for this ecosystem since it launched.
* Happy they are using their ill gained monopoloy money to do something cool.
*
*  Reference for when I forget exactly how this works
* https://developer.android.com/kotlin/flow/stateflow-and-sharedflow
* */
class Screen2ViewModel: ViewModel() {

    private val _title: MutableSharedFlow<String> = MutableStateFlow("Screen 2: title 0")
    val title: Flow<String> = _title
        //.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "title1")

    init {
        viewModelScope.launch {
            for(i in 1 .. 9) {
                _title.emit("Screen 2: title $i")
                delay(2000)
            }
        }
    }
}