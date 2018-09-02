package com.eugene.mvppractice.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.eugene.mvppractice.MvpPracticeApp
import com.eugene.mvppractice.R
import com.eugene.mvppractice.model.Task
import com.eugene.mvppractice.ui.adapter.TasksAdapter
import com.eugene.mvppractice.ui.main.dagger.MainActivityModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var mPresenter: MainPresenter

    lateinit var adapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MvpPracticeApp.get(this).getAppComponent()?.plus(MainActivityModule())?.inject(this)
        mPresenter.attachView(this)
        setupRecyclerView()
        mPresenter.loadTasks()
        fab.setOnClickListener { mPresenter.generateTask() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.clear_all -> mPresenter.clearAllTasks()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupRecyclerView() {
        adapter = TasksAdapter(appExecutors = mPresenter.appExecutors,
                callback = { task, view -> onTaskClick(task, view) })
        rv_tasks.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL).apply {
            ContextCompat.getDrawable(this@MainActivity, R.drawable.divider_line)?.let {
                setDrawable(it)
            }
        })
        rv_tasks.adapter = adapter
    }

    private fun onTaskClick(item: Task, view: View) {
        when (view.id) {
            R.id.task_delete_button -> mPresenter.deleteTask(item)
        }
    }

    override fun showTasks(tasks: List<Task>) {
        adapter.submitList(tasks)
    }
}
