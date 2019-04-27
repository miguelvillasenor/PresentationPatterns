package dev.mvillasenor.presentationpatterns.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvillasenor.bookfinder.domain.Book
import dev.mvillasenor.presentationpatterns.domain.usecases.SearchBook
import dev.mvillasenor.presentationpatterns.ui.common.Resource
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class SearchViewModel(private val searchBook: SearchBook) : ViewModel() {

    private val _searchResult = MutableLiveData<Resource<List<Book>>>()
    val searchResult get() = _searchResult as LiveData<Resource<List<Book>>>


    fun performSearch(query: String) {
        viewModelScope.coroutineContext.cancelChildren()
        viewModelScope.launch {
            try {
                _searchResult.postValue(Resource.loading())
                val result = searchBook.invoke(query, 1)
                _searchResult.postValue(Resource.success(result.books))
            } catch (e: CancellationException) {
                Timber.d("Search canceled")
            } catch (e: Exception) {
                Timber.e(e)
                _searchResult.postValue(Resource.error("Error performing search"))
            }
        }
    }

}
