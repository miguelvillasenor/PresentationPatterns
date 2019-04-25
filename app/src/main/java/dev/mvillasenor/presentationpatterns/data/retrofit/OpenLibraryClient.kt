package dev.mvillasenor.presentationpatterns.data.retrofit

import dev.mvillasenor.presentationpatterns.data.SearchResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryClient {

    @GET("search.json")
    fun searchAsync(@Query("q") query: String, @Query("page") page: Int?): Deferred<SearchResult>

}
