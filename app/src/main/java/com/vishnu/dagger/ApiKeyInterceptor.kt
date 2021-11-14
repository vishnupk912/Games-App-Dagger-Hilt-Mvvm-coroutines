package com.vishnu.dagger

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var chainRequest=chain.request()
        val interceptUrl=chainRequest.url.newBuilder().addQueryParameter("key","c005c4a7cf134a3098b5f62487aaf991")
            .build()
        chainRequest=chainRequest.newBuilder().url(interceptUrl).build()
        return  chain.proceed(chainRequest)
    }
}