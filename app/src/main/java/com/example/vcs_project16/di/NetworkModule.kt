package com.example.vcs_project16.di

import com.example.vcs_project16.data.remote.api.NewsApi
import com.example.vcs_project16.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(
    SingletonComponent::class
)
object NetworkModule {
    @Provides
    @Singleton
    fun provideLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    @Provides
    @Singleton
    fun provideClient(
        logging: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(
                Constants.BASE_URL
            )
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }
    @Provides
    @Singleton
    fun provideNewsApi(
        retrofit: Retrofit
    ): NewsApi {
        return retrofit.create(
            NewsApi::class.java
        )
    }
}