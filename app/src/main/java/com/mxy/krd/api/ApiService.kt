package com.mxy.krd.api

import com.mxy.krd.model.AnswerResponse
import retrofit2.http.GET

/**
 * Created by Mengxy on 2019-07-23.
 */

interface ApiService {

    @GET("api")
    suspend fun getDataFromServerAsync(): AnswerResponse

}