package dev.mvillasenor.presentationpatterns.ui.search

import dev.mvillasenor.presentationpatterns.domain.usecases.SearchBook
import kotlinx.coroutines.*
import timber.log.Timber
import java.io.Closeable
import java.io.IOException
import kotlin.coroutines.CoroutineContext

class SearchPresenter(
    private val view: Search.View,
    private val searchBook: SearchBook
) : Search.Presenter {

    private val parentJob = SupervisorJob()
    private val coroutineScope = CloseableCoroutineScope(parentJob + Dispatchers.Main.immediate)

    override fun stop() {
        coroutineScope.close()
    }

    override fun makeQuery(query: String) {
        parentJob.cancelChildren()
        coroutineScope.launch {
            try {
                view.showLoading()
                val results = searchBook.invoke(query, 1)
                view.showResults(results)
            } catch (e: IOException) {
                Timber.e(e)
                view.showError("Error performing search")
            }
        }
    }
}

internal class CloseableCoroutineScope(context: CoroutineContext) : Closeable, CoroutineScope {
    override val coroutineContext: CoroutineContext = context

    override fun close() {
        coroutineContext.cancel()
    }
}
