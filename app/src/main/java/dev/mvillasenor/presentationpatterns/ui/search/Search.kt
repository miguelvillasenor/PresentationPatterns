package dev.mvillasenor.presentationpatterns.ui.search

import com.mvillasenor.bookfinder.domain.SearchResult

object Search {

    const val SUCCESS_VIEW_INDEX = 0
    const val LOADING_VIEW_INDEX = 1
    const val ERROR_VIEW_INDEX = 2

    interface View {
        fun showResults(searchResult: SearchResult)
        fun showError(error: String)
        fun showLoading()
    }


    interface Presenter {
        fun stop()
        fun makeQuery(query: String)
    }
}
