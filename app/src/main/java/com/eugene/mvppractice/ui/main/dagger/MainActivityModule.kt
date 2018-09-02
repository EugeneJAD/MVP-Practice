package com.eugene.mvppractice.ui.main.dagger

import android.content.res.Resources
import com.eugene.mvppractice.AppExecutors
import com.eugene.mvppractice.data.Repository
import com.eugene.mvppractice.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainPresenter(repository: Repository, appExecutors: AppExecutors, resources: Resources):
            MainPresenter  = MainPresenter(repository, appExecutors, resources)
}