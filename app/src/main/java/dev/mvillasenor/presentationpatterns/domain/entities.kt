package com.mvillasenor.bookfinder.domain

data class SearchResult(
    val currentPage: Int,
    val hasMore: Boolean,
    val books: List<Book>
)

data class Book(
    val key: String,
    val title: String,
    val authorName: List<String>,
    val coverUrl: String?,
    val publishYear: String?
)