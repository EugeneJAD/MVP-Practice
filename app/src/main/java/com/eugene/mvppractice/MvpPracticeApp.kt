package com.eugene.mvppractice

import android.app.Application
import android.content.Context
import com.eugene.mvppractice.di.AppComponent
import com.eugene.mvppractice.di.AppModule
import com.eugene.mvppractice.di.DaggerAppComponent
import com.eugene.mvppractice.di.DataModule

class MvpPracticeApp : Application() {

    private lateinit var mAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .dataModule(DataModule(this))
                .build()
    }

    /**
     * @return the dependency injection application component.
     */
    fun getAppComponent(): AppComponent? = mAppComponent

    companion object {

        /**
         * Returns this custom application.
         * @return this
         */
        fun get(context: Context): MvpPracticeApp = context.applicationContext as MvpPracticeApp
    }
}