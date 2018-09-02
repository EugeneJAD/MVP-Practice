package com.eugene.mvppractice.data

import com.eugene.mvppractice.model.Task
import io.reactivex.Flowable

interface Repository {

    fun loadTasks(): Flowable<List<Task>>
    fun insertTask(task: Task)
    fun deleteTask(task: Task)
    fun clearTasks()
}