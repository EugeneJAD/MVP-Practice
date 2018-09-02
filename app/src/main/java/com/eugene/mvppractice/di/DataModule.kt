package com.eugene.mvppractice.di

import android.app.Application
import android.arch.persistence.room.Room
import com.eugene.mvppractice.data.DataRepository
import com.eugene.mvppractice.data.Repository
import com.eugene.mvppractice.data.database.MvpPracticeDb
import com.eugene.mvppractice.data.database.TasksDAO
import com.eugene.mvppractice.utils.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule(private val application: Application) {

    @Provides @Singleton
    fun provideRepository(dataRepository: DataRepository): Repository {
        return dataRepository
    }

    @Singleton
    @Provides
    fun provideDb(): MvpPracticeDb {
        return Room
                .databaseBuilder(application, MvpPracticeDb::class.java, AppConstants.MVP_PRACTICE_DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideTasksDAO(db: MvpPracticeDb): TasksDAO {
        return db.tasksDAO()
    }
}