package dev.mvillasenor.presentationpatterns.ui.search

import com.mvillasenor.bookfinder.domain.SearchResult

object Search {

    interface View {
        fun showResults(searchResult: SearchResult)
        fun showError(error: String)
    }


    interface Presenter {
        fun start()
        fun stop()
        fun makeQuery(query: String)
    }
}
