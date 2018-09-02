package com.eugene.mvppractice.ui.main

import android.content.res.Resources
import com.eugene.mvppractice.AppExecutors
import com.eugene.mvppractice.R
import com.eugene.mvppractice.data.Repository
import com.eugene.mvppractice.model.Task
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by Eugene on 9/2/2018.
 */
class MainPresenter(private val repository: Repository,
                    val appExecutors: AppExecutors,
                    private val resources: Resources) : IMainPresenter {

    private var mView: IMainView? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: IMainView) {
        mCompositeDisposable = CompositeDisposable()
        mView = view
    }

    override fun detachView() {
        mCompositeDisposable?.clear()
        mView = null
    }

    override fun loadTasks() {
        val disposable = repository.loadTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError)
        mCompositeDisposable?.add(disposable)
    }

    private fun handleResults(results: List<Task>) {
        mView?.showTasks(results)
    }

    private fun handleError(error: Throwable) {
        Timber.d(error.message)
    }

    override fun generateTask() {
        repository.insertTask(Task(resources.getString(R.string.task_content)))
    }

    override fun deleteTask(item: Task) {
        repository.deleteTask(item)
    }

    override fun clearAllTasks() {
        repository.clearTasks()
    }
}