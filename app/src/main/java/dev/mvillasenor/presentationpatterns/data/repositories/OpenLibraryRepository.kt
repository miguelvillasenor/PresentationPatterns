package dev.mvillasenor.presentationpatterns.data.repositories

import dev.mvillasenor.presentationpatterns.data.SearchResult
import kotlinx.coroutines.Deferred

interface OpenLibraryRepository {

    suspend fun search(query: String, page: Int? = null): SearchResult

}
