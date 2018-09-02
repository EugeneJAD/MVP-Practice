package com.eugene.mvppractice.data

import com.eugene.mvppractice.AppExecutors
import com.eugene.mvppractice.data.database.TasksDAO
import com.eugene.mvppractice.model.Task
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val tasksDAO: TasksDAO,
                                         private val appExecutors: AppExecutors) : Repository {

    override fun loadTasks(): Flowable<List<Task>> = tasksDAO.loadTasks()

    override fun insertTask(task: Task) {
        appExecutors.diskIO().execute { tasksDAO.insert(task) }
    }

    override fun clearTasks() {
        appExecutors.diskIO().execute { tasksDAO.clearTasks() }
    }

    override fun deleteTask(task: Task) {
        appExecutors.diskIO().execute { tasksDAO.deleteTask(task) }
    }
}