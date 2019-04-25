package dev.mvillasenor.presentationpatterns.ui.search

import dev.mvillasenor.presentationpatterns.domain.usecases.SearchBook
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchPresenter(val view: Search.View, val searchBook: SearchBook) : Search.Presenter {

    private val presenterJob = Job()
    private val coroutineScope = CoroutineScope(presenterJob + Dispatchers.Main)

    override fun start() {

    }

    override fun stop() {
        presenterJob.cancel()
    }

    override fun makeQuery(query: String) {
        coroutineScope.launch {
            try {
                val results = searchBook.invoke(query, 1)
                view.showResults(results)
            } catch (e: Exception) {
                Timber.e(e)
                view.showError("Error performing search")
            }
        }
    }
}
