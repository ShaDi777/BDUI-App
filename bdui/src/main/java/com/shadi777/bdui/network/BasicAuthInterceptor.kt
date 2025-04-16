package com.shadi777.bdui.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(
    private val username: String,
    private val password: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val credentials = Credentials.basic(username, password)
        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Authorization", credentials)
            .build()
        return chain.proceed(newRequest)
    }
}
