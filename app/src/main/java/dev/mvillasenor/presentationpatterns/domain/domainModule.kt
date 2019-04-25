package dev.mvillasenor.presentationpatterns.domain

import dev.mvillasenor.presentationpatterns.domain.usecases.OpenLibrarySearchBook
import dev.mvillasenor.presentationpatterns.domain.usecases.SearchBook
import org.koin.dsl.module.module

val domainModule = module {
    single<SearchBook> { OpenLibrarySearchBook(get()) }
}
