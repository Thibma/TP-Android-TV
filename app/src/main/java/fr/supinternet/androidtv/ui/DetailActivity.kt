package fr.supinternet.androidtv.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import fr.supinternet.androidtv.data.network.model.Movie

class DetailActivity() : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movie = intent.getSerializableExtra("movie") as Movie

        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, DetailFragment(movie))
            .commitAllowingStateLoss()
    }
}