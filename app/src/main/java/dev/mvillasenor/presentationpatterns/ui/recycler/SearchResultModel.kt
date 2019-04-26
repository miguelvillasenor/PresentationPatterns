package dev.mvillasenor.presentationpatterns.ui.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.squareup.picasso.Picasso
import dev.mvillasenor.presentationpatterns.R


@EpoxyModelClass(layout = R.layout.item_search_result)
abstract class SearchResultModel : EpoxyModelWithHolder<SearchResultModel.Holder>() {

    @EpoxyAttribute
    lateinit var title: String
    @EpoxyAttribute
    var cover: String? = null
    @EpoxyAttribute
    lateinit var author: String

    override fun bind(holder: Holder) {
        if (cover != null) {
            holder.cover.visibility = View.VISIBLE
            Picasso.get()
                .load(cover)
                .into(holder.cover)
        } else {
            holder.cover.visibility = View.GONE
        }
        holder.title.text = title
        holder.author.text = author
    }

    class Holder : EpoxyHolder() {
        lateinit var cover: ImageView
        lateinit var title: TextView
        lateinit var author: TextView

        override fun bindView(itemView: View) {
            cover = itemView.findViewById(R.id.cover)
            title = itemView.findViewById(R.id.title)
            author = itemView.findViewById(R.id.author)
        }
    }

}


