package dev.mvillasenor.presentationpatterns.ui

import dev.mvillasenor.presentationpatterns.ui.recycler.SearchController
import dev.mvillasenor.presentationpatterns.ui.search.Search
import dev.mvillasenor.presentationpatterns.ui.search.SearchPresenter
import org.koin.dsl.module.module

val presentationModule = module {
    factory { (view: Search.View) -> SearchPresenter(view, get()) as Search.Presenter }
    factory { SearchController() }
}
