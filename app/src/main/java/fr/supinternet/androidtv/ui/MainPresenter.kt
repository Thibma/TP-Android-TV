package fr.supinternet.androidtv.ui

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import fr.supinternet.androidtv.data.network.model.Movie

class MainPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        return CardViewHolder(ImageCardView(parent?.context))
    }

    override fun onBindViewHolder (viewHolder: ViewHolder?, item: Any?) {
        val movie = item as Movie

        val holder = viewHolder as CardViewHolder
        val img = holder.card
        val titleText = movie.name
        val contentText = movie.rating
        movie.posterURL?.let { holder.loadImage(it) }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {

    }

}