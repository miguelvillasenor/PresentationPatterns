package dev.mvillasenor.presentationpatterns.ui.search

import dev.mvillasenor.presentationpatterns.domain.usecases.SearchBook
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

class SearchPresenter(
    private val view: Search.View,
    private val searchBook: SearchBook
) {

    private val parentJob = SupervisorJob()
    private val coroutineScope = CloseableCoroutineScope(parentJob + Dispatchers.Main.immediate)

}

internal class CloseableCoroutineScope(context: CoroutineContext) : Closeable, CoroutineScope {
    override val coroutineContext: CoroutineContext = context

    override fun close() {
        coroutineContext.cancel()
    }
}
