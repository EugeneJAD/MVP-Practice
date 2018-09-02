package com.eugene.mvppractice.ui.main

import com.eugene.mvppractice.model.Task
import com.eugene.mvppractice.ui.base.IView

interface IMainView : IView {

    fun showTasks(tasks: List<Task>)
}