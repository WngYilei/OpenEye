package com.xl.openeye.di

import com.xl.openeye.nei.EyeApi
import com.xl.xl_base.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideUnsplashService(): EyeApi =
        ApiService("http://baobab.kaiyanapp.com/api/").retrofit.create(EyeApi::class.java)
}