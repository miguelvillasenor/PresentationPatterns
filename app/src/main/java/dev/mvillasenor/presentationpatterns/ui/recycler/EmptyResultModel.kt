package dev.mvillasenor.presentationpatterns.ui.recycler

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import dev.mvillasenor.presentationpatterns.R


@EpoxyModelClass(layout = R.layout.item_no_results)
abstract class EmptyResultModel : EpoxyModelWithHolder<EmptyResultModel.Holder>() {

    override fun bind(holder: Holder) {
    }

    class Holder : EpoxyHolder() {
        override fun bindView(itemView: View) {
        }
    }

}


