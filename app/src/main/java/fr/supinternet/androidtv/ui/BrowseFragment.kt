package fr.supinternet.androidtv.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import fr.supinternet.androidtv.R
import fr.supinternet.androidtv.data.network.NetworkManager
import fr.supinternet.androidtv.data.network.model.Movie
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BrowseFragment : BrowseSupportFragment() {

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prepareEntranceTransition()

        val fragmentAdapter = ArrayObjectAdapter(ListRowPresenter())
        adapter = fragmentAdapter

        GlobalScope.launch {
            val boxOffice = NetworkManager.getBoxOffice()
            val boxOfficeAdapter = ArrayObjectAdapter(MainPresenter())
            for (movie: Movie in boxOffice) {
                boxOfficeAdapter.add(movie)
            }
            fragmentAdapter.add(ListRow(HeaderItem(0, "Les sorties"), boxOfficeAdapter))

            val movieRating = NetworkManager.getAnticipatedMovies()
            val movieRatingAdapter = ArrayObjectAdapter(MainPresenter())
            for (movie: Movie in movieRating) {
                movieRatingAdapter.add(movie)
            }
            fragmentAdapter.add(ListRow(HeaderItem(1, "Films les plus attendus"), movieRatingAdapter))
        }
        setOnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
            startActivity(Intent(context, DetailActivity()::class.java).putExtra("movie", item as Movie))
        }

        startEntranceTransition()

    }

}
