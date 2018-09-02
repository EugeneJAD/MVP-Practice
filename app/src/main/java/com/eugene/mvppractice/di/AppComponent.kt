package com.eugene.mvppractice.di

import com.eugene.mvppractice.ui.main.dagger.MainActivityModule
import com.eugene.mvppractice.ui.main.dagger.MainActivitySubComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Dependency injection application component.
 */
@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {

    fun plus(mainActivityModule: MainActivityModule): MainActivitySubComponent
}
