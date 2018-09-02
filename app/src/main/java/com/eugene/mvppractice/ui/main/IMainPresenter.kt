package com.eugene.mvppractice.ui.main

import com.eugene.mvppractice.model.Task
import com.eugene.mvppractice.ui.base.IPresenter

interface IMainPresenter : IPresenter<IMainView> {

    fun loadTasks()
    fun deleteTask(item: Task)
    fun generateTask()
    fun clearAllTasks()
}