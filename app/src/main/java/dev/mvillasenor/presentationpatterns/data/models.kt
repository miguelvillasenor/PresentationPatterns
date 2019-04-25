package dev.mvillasenor.presentationpatterns.data

import com.google.gson.annotations.SerializedName

data class SearchResultItem(
    val key: String,
    val title: String,
    @SerializedName("author_name")
    val authorName: List<String>?,
    @SerializedName("cover_i")
    val coverId: String?,
    @SerializedName("first_publish_year")
    val publishYear: String?
)

data class SearchResult(
    val docs: List<SearchResultItem>,
    val start: Int,
    val numFound: Int
)
