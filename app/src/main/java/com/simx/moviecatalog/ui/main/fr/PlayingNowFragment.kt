package com.simx.moviecatalog.ui.main.fr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.simx.moviecatalog.R
import com.simx.moviecatalog.components.FooterAdapter
import com.simx.moviecatalog.components.movie.AdapterMovie
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.databinding.PlayingNowFragmentBinding
import com.simx.moviecatalog.ui.main.MainVm
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PlayingNowFragment : Fragment() {
    private lateinit var binding:PlayingNowFragmentBinding
    private lateinit var vm:MainVm

    private var  adapterMove:AdapterMovie? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.playing_now_fragment, container,false)
        vm = MainVm()
        binding.lifecycleOwner = this
        binding.mainVm = vm
        adapterMove = AdapterMovie(object : AdapterMovie.OnAdapterMovieListener {
            override fun onClick(dat: Movie?) {
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch { vm.movies("now_playing").collectLatest { adapterMove?.submitData(it) } }
        adapterMove?.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading){
                vm.loading.set(loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading)
            }else {
                vm.loading.set(false)
                val error = when {
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                if (error != null) vm.errorMsg.postValue(error.error.message)
            }
        }

        binding.rcvNowPlaying.apply {
            hasFixedSize()
            itemAnimator = DefaultItemAnimator()
            layoutManager = GridLayoutManager(this@PlayingNowFragment.context, 2)
            adapter = adapterMove?.withLoadStateFooter(footer = FooterAdapter { adapterMove?.retry()})
        }
        vm.errorMsg.observe(viewLifecycleOwner, { Snackbar.make(binding.rootView, it, Snackbar.LENGTH_SHORT).show()})
    }

}