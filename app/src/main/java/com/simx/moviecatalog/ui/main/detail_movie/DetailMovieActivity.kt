package com.simx.moviecatalog.ui.main.detail_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.simx.moviecatalog.R
import com.simx.moviecatalog.data.GlobalTools
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.databinding.DetailMovieActivityBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding:DetailMovieActivityBinding
    private lateinit var vm:DetailMovieVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.detail_movie_activity)
        vm = DetailMovieVM()
        binding.lifecycleOwner = this
        binding.detailMovieVm = vm
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        intent.takeIf { it.hasExtra(KEY_DATA) }?.extras?.getParcelable<Movie>(KEY_DATA).let {
            vm.movie.postValue(it)
        }
        vm.movie.observe(this, { data ->
            vm.videos(data.id)
            GlobalTools.loadImage(binding.imgPoster, GlobalTools.image500(data.posterPath))
            binding.collapsingToolbar.title = data.originalTitle
            binding.tvOverview.text = data.overview
            binding.tvRate.text = data.voteAverage.toString()

            binding.collapsingToolbar.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white))
            binding.collapsingToolbar.setExpandedTitleColor(ContextCompat.getColor(this, R.color.design_default_color_primary))
        })

    }

    companion object {
        const val KEY_DATA = "key_data"
    }
}