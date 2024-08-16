package com.matrix.android105_android.presentation.di.module

import com.matrix.android105_android.data.api.services.ProductService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val retrofit= Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideClient())
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideProductService(retrofit: Retrofit):ProductService{
        return retrofit.create(ProductService::class.java)
    }

    @Provides
    fun provideClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
        return client
    }
}