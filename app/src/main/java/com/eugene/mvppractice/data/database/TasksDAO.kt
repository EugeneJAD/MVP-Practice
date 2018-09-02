package com.eugene.mvppractice.data.database

import android.arch.persistence.room.*
import com.eugene.mvppractice.model.Task
import io.reactivex.Flowable

@Dao
interface TasksDAO {

    @Query("SELECT * FROM tasks")
    fun loadTasks(): Flowable<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("DELETE FROM tasks")
    fun clearTasks()
}