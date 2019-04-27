package dev.mvillasenor.presentationpatterns.ui

import dev.mvillasenor.presentationpatterns.ui.recycler.SearchController
import dev.mvillasenor.presentationpatterns.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {
    viewModel { SearchViewModel(get()) }
    factory { SearchController() }
}
