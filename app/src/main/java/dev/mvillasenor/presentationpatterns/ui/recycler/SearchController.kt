package dev.mvillasenor.presentationpatterns.ui.recycler

import com.airbnb.epoxy.TypedEpoxyController
import com.mvillasenor.bookfinder.domain.Book

class SearchController : TypedEpoxyController<List<Book>>() {
    override fun buildModels(books: List<Book>?) {
        if (books.isNullOrEmpty()) {
            emptyResult { id("empty") }
        }

        books?.forEach {
            searchResult {
                id(it.key)
                title(it.title)
                cover(it.coverUrl)
                author(it.authorName.joinToString(", "))
            }
        }
    }
}
