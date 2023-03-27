package com.example.github.di

import android.annotation.SuppressLint
import com.example.github.data.localStorage.LocalStorage
import okhttp3.Interceptor
import okhttp3.Response

class GithubInterceptor:Interceptor {
    @SuppressLint("SuspiciousIndentation")
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${LocalStorage().token}").build()
            return chain.proceed(request)
    }

}