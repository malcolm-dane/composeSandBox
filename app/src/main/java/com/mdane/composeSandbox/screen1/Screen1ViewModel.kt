package com.mdane.composeSandbox.screen1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class Screen1ViewModel: ViewModel() {
/*
* Per google:
* Key Points:

mutableStateOf(value) creates a MutableState, which is an observable type in Compose.
* Any changes to its value will schedule recomposition of any composable functions that read that value.

remember stores objects in the composition, and forgets the object when the composable that called remember is removed from the composition.

rememberSaveable retains the state across configuration changes by saving it in a Bundle.

*
*
*
*
*
*
* */
    private val _title: MutableSharedFlow<String> = MutableStateFlow("Screen 1: title 0")
    val title: Flow<String> = _title

    init {
        viewModelScope.launch {
            for(i in 1 .. 5) {
                _title.emit("Screen 1: title $i")
                delay(2000)


                if(i >= 5)
                {
                    for(i in 5 downTo 1) {
                    _title.emit("Screen 1: title $i")
                    delay(2000)

                    if(i==1){
                        emitThis(_title)

                    }
                    }

            }}
        }
}

    //Now it just loops forever. Need to add httpclient and repo so I can emit from the cloud
private suspend fun emitThis(_title: MutableSharedFlow<String>) {
    for(i in 1 .. 5) {
        _title.emit("Screen 1: title $i")
        delay(2000)


        if(i >= 5)
        {
            for(i in 5 downTo 1) {
                _title.emit("Screen 1: title $i")
                delay(2000)
                if(i==1){
                    emitThis(_title)

                }
            }

        }}

}

}