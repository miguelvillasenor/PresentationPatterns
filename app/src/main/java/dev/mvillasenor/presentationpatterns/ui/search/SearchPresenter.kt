package dev.mvillasenor.presentationpatterns.ui.search

import dev.mvillasenor.presentationpatterns.domain.usecases.SearchBook
import kotlinx.coroutines.*
import timber.log.Timber

class SearchPresenter(val view: Search.View, val searchBook: SearchBook) : Search.Presenter {

    private val presenterJob = Job()
    private val coroutineScope = CoroutineScope(presenterJob + Dispatchers.Main)

    override fun stop() {
        presenterJob.cancel()
    }

    override fun makeQuery(query: String) {
        presenterJob.cancelChildren()
        coroutineScope.launch {
            try {
                view.showLoading()
                val results = searchBook.invoke(query, 1)
                view.showResults(results)
            } catch (e: CancellationException) {
                Timber.e("Job was canceled")
            }
            catch (e: Exception) {
                Timber.e(e)
                view.showError("Error performing search")
            }
        }
    }
}
