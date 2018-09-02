package com.eugene.mvppractice.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.eugene.mvppractice.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class MvpPracticeDb: RoomDatabase() {

    abstract fun tasksDAO(): TasksDAO
}