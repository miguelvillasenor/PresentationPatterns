package dev.mvillasenor.presentationpatterns.data.repositories

import dev.mvillasenor.presentationpatterns.data.SearchResult
import dev.mvillasenor.presentationpatterns.data.retrofit.OpenLibraryClient
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit

class RetrofitOpenLibraryRepository(retrofit: Retrofit) : OpenLibraryRepository {

    private val openLibraryClient: OpenLibraryClient = retrofit.create(OpenLibraryClient::class.java)

    override suspend fun search(query: String, page: Int?): SearchResult = openLibraryClient.searchAsync(query, page)

}
