package fr.supinternet.androidtv.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.annotation.UiThread
import androidx.core.content.ContextCompat
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import fr.supinternet.androidtv.R
import fr.supinternet.androidtv.data.network.model.Movie
import kotlinx.coroutines.*
import java.lang.Exception

class DetailFragment(private val movie: Movie): DetailsSupportFragment() {

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            // On imagine que l'objet Movie est déjà alimenté et se nomme movie
            val detailRow = DetailsOverviewRow(movie)

            val detailsPresenter = FullWidthDetailsOverviewRowPresenter(
                DetailPresenter(requireContext()))

            // On change la couleur de fond
            detailsPresenter.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.colorAccent
                ))

            detailsPresenter.initialState = FullWidthDetailsOverviewRowPresenter.STATE_FULL

            val ps = ClassPresenterSelector()
            ps.addClassPresenter(DetailsOverviewRow::class.java, detailsPresenter)
            ps.addClassPresenter(ListRow::class.java, ListRowPresenter())

            adapter = ArrayObjectAdapter(ps).apply { add(detailRow) }

            detailRow.actionsAdapter = ActionAdapter().apply {
                set(0, Action(0, "Voir le trailer"))
            }

            detailsPresenter.setOnActionClickedListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(movie.trailerURL)
                startActivity(intent)
            }

            GlobalScope.launch {
                movie.posterURL?.let { loadImage(it, detailRow) }
            }


        GlobalScope.launch {
            movie.posterURL?.let { loadBackgroundImage(it) }
        }

    }

    @UiThread
    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun loadImage(url: String, detailRow: DetailsOverviewRow) {
        try {
            val bitmap = Glide.with(requireActivity())
                .asBitmap()
                .load(movie.posterURL)
                .apply(RequestOptions().apply { centerCrop() })
                .submit(250, 250)
                .get()
            detailRow.setImageBitmap(requireContext(), bitmap)
        } catch (e: Exception) {

        }

    }

    @UiThread
    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun loadBackgroundImage(url: String) {
        val metrics  = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(metrics )

        try {
            val drawable = Glide.with(requireActivity())
                .asDrawable()
                .load(url)
                .apply(RequestOptions().apply { centerCrop() })
                .submit()
                .get()

            withContext(Dispatchers.Main) {
                requireActivity().window.decorView.background = drawable
            }
        }
        catch (e: Exception) {

        }


    }

}