package dev.mvillasenor.presentationpatterns.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvillasenor.bookfinder.domain.SearchResult
import dev.mvillasenor.presentationpatterns.R
import dev.mvillasenor.presentationpatterns.ui.recycler.SearchController
import dev.mvillasenor.presentationpatterns.ui.search.Search.ERROR_VIEW_INDEX
import dev.mvillasenor.presentationpatterns.ui.search.Search.LOADING_VIEW_INDEX
import dev.mvillasenor.presentationpatterns.ui.search.Search.SUCCESS_VIEW_INDEX
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_error.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchActivity : AppCompatActivity() {

    val presenter: Search.Presenter by inject { parametersOf(this) }
    private val searchController: SearchController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && s.isNotEmpty()) {
                    presenter.makeQuery(s.toString())
                } else {
                    searchController.setData(listOf())
                }
            }
        })

        searchResults.layoutManager = LinearLayoutManager(this)
        searchResults.adapter = searchController.adapter

        retry.setOnClickListener {
            presenter.makeQuery(searchText.text.toString())
        }
    }

    override fun onPause() {
        super.onPause()
        presenter.stop()
    }
}
