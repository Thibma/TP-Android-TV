package fr.supinternet.androidtv.ui

import android.content.Context
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter
import fr.supinternet.androidtv.data.network.model.Movie

class DetailPresenter(private val context: Context) : AbstractDetailsDescriptionPresenter() {
    override fun onBindDescription(vh: ViewHolder?, item: Any?) {
        val movie : Movie = item as Movie

        if (vh != null) {
            vh.title.text= movie.name
            vh.subtitle.text = movie.actors.toString()
            vh.body.text = movie.overview
        }
    }
}