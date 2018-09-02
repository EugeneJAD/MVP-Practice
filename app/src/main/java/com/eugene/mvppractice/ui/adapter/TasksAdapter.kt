package com.eugene.mvppractice.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.mvppractice.AppExecutors
import com.eugene.mvppractice.R
import com.eugene.mvppractice.databinding.TaskListItemBinding
import com.eugene.mvppractice.model.Task
import com.eugene.mvppractice.ui.base.DataBoundListAdapter

class TasksAdapter(appExecutors: AppExecutors, private val callback: ((Task, View) -> Unit)?) :
        DataBoundListAdapter<Task, TaskListItemBinding>(
                appExecutors = appExecutors,
                diffCallback = object : DiffUtil.ItemCallback<Task>() {
                    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                        return oldItem.id == newItem.id
                    }

                    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                        return oldItem.content == newItem.content
                    }
                }
        ) {

    override fun createBinding(parent: ViewGroup): TaskListItemBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.task_list_item, parent, false)
    }

    override fun bind(binding: TaskListItemBinding, item: Task, position: Int) {
        binding.task = item
        binding.taskDeleteButton.setOnClickListener { callback?.invoke(item, it) }
    }
}