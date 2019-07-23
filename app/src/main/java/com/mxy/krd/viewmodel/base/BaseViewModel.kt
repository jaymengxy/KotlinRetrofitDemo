package com.mxy.krd.viewmodel.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

/**
 * Created by Mengxy on 2019-07-23.
 */

open class BaseViewModel : ViewModel() {

    val viewModelScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
