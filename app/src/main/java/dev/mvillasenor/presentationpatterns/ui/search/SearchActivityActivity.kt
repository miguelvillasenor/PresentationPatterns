package dev.mvillasenor.presentationpatterns.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvillasenor.bookfinder.domain.Book
import dev.mvillasenor.presentationpatterns.R
import dev.mvillasenor.presentationpatterns.ui.common.Resource
import dev.mvillasenor.presentationpatterns.ui.common.Status
import dev.mvillasenor.presentationpatterns.ui.recycler.SearchController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_error.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivityActivity : AppCompatActivity() {

    companion object {
        private const val SUCCESS_INDEX = 0
        private const val LOADING_INDEX = 1
        private const val ERROR_INDEX = 2
    }

    val viewModel: SearchViewModel by viewModel()
    private val searchController: SearchController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchResults.layoutManager = LinearLayoutManager(this)
        searchResults.adapter = searchController.adapter

        searchText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && s.isNotEmpty()) {
                    viewModel.performSearch(s.toString())
                }
            }
        })

        retry.setOnClickListener {
            viewModel.performSearch(searchText.text.toString())
        }

        viewModel.searchResult.observe(this, ::handleResult)
    }

    private fun handleResult(result: Resource<List<Book>>) {
        when (result.status) {
            Status.SUCCESS -> {
                animator.displayedChild = SUCCESS_INDEX
                searchController.setData(result.data)
            }
            Status.ERROR -> {
                animator.displayedChild = ERROR_INDEX
                errorMessage.text = result.message
            }
            Status.LOADING -> animator.displayedChild = LOADING_INDEX
        }
    }
}
