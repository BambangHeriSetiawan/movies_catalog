package com.simx.moviecatalog.components.movie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.simx.moviecatalog.ui.main.fr.PlayingNowFragment
import com.simx.moviecatalog.ui.main.fr.PopularFragment
import com.simx.moviecatalog.ui.main.fr.TopRatedFragment
import com.simx.moviecatalog.ui.main.fr.UpcomingFragment

class MoviePageAdapter( var fa:FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> PlayingNowFragment()
            1 -> TopRatedFragment()
            2 -> UpcomingFragment()
            else -> PopularFragment()
        }
    }
}