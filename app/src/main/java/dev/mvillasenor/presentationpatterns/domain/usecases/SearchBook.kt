package dev.mvillasenor.presentationpatterns.domain.usecases

import com.mvillasenor.bookfinder.domain.SearchResult
import dev.mvillasenor.presentationpatterns.data.repositories.OpenLibraryRepository
import dev.mvillasenor.presentationpatterns.domain.toEntity

interface SearchBook {

    suspend fun invoke(query: String, page: Int): SearchResult

}

class OpenLibrarySearchBook(
    private val openLibraryRepository: OpenLibraryRepository
) : SearchBook {

    override suspend fun invoke(query: String, page: Int): SearchResult =
        openLibraryRepository
            .search(query, page)
            .await()
            .toEntity(page)

}
