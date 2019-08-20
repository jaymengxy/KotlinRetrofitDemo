package com.mxy.krd.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mxy.krd.api.ApiClient
import com.mxy.krd.model.AnswerResponse
import com.mxy.krd.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Mengxy on 2019-07-23.
 */

class CustomViewModel : BaseViewModel() {

    val answerLiveData: MutableLiveData<AnswerResponse> = MutableLiveData()

    fun getDataFromServer() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = ApiClient.getService().getDataFromServerAsync()
                answerLiveData.postValue(result)
            }
        }
    }
}
