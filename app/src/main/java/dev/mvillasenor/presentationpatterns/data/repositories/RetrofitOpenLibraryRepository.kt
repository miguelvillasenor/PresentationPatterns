package dev.mvillasenor.presentationpatterns.data.repositories

import dev.mvillasenor.presentationpatterns.data.SearchResult
import dev.mvillasenor.presentationpatterns.data.retrofit.OpenLibraryClient
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit

class RetrofitOpenLibraryRepository(retrofit: Retrofit) : OpenLibraryRepository {

    private val openLibraryClient: OpenLibraryClient = retrofit.create(OpenLibraryClient::class.java)

    override fun search(query: String, page: Int?): Deferred<SearchResult> = openLibraryClient.searchAsync(query, page)

}
