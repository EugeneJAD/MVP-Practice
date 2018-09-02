package com.eugene.mvppractice.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideResources(): Resources = application.resources
}
