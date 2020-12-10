package pl.mateuszteteruk.lastfmlibrary.core.dataaccess.api

import okhttp3.Interceptor
import okhttp3.Response
import pl.mateuszteteruk.lastfmlibrary.BuildConfig

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val url = originalRequest.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.LASTFM_API_KEY)
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)

        return chain.proceed(requestBuilder.build())
    }

}