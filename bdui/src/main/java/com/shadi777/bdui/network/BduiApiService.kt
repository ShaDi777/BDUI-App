package com.shadi777.bdui.network

import com.shadi777.bdui.models.BduiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface BduiApiService {
    @GET("{key}")
    suspend fun loadBDUI(@Path("key") key: String): BduiModel
}
