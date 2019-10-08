package dev.mvillasenor.presentationpatterns.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvillasenor.bookfinder.domain.Book
import dev.mvillasenor.presentationpatterns.domain.usecases.SearchBook
import dev.mvillasenor.presentationpatterns.ui.common.Resource
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException

class SearchViewModel(private val searchBook: SearchBook) : ViewModel() {

    private val _searchResult = MutableLiveData<Resource<List<Book>>>()
    val searchResult get() = _searchResult as LiveData<Resource<List<Book>>>


}
