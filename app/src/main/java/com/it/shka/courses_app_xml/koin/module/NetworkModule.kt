package com.it.shka.courses_app_xml.koin.module

import com.it.shka.feature_main.data.network.ApiCourses
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module{
    single<Interceptor>{
        Interceptor{chain ->
            val originalRequest: Request = chain.request()
            val requestWithHeaders = originalRequest.newBuilder()
                .header("Content-Type", "text/plain")
                .build()
            chain.proceed(requestWithHeaders)
        }
    }
    single<OkHttpClient> {
        OkHttpClient.Builder().addInterceptor(get<Interceptor>())
            .connectTimeout(30, TimeUnit.SECONDS) // Таймаут соединения
            .readTimeout(30, TimeUnit.SECONDS)    // Таймаут чтения данных
            .writeTimeout(30, TimeUnit.SECONDS)   // Таймаут записи данных
            .build()

    }
    single<Retrofit>{
        Retrofit.Builder().baseUrl("http://192.168.56.1:3700")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(get<OkHttpClient>())
            .build()
    }
    single<ApiCourses> {
        get<Retrofit>().create(ApiCourses::class.java)
    }
}