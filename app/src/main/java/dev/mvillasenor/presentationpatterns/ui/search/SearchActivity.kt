package dev.mvillasenor.presentationpatterns.ui.search

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mvillasenor.bookfinder.domain.SearchResult
import dev.mvillasenor.presentationpatterns.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchActivity : AppCompatActivity(), Search.View {

    val presenter: Search.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.start()
        presenter.makeQuery("test")
    }

    override fun showResults(searchResult: SearchResult) {
        Toast.makeText(this, "items: ${searchResult.books.size}", Toast.LENGTH_LONG).show()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}
