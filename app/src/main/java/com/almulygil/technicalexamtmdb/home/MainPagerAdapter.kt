package com.almulygil.technicalexamtmdb.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.almulygil.technicalexamtmdb.home.popular.ui.fragment.PopularMoviesFragment
import com.almulygil.technicalexamtmdb.home.profile.ui.fragment.ProfileMoviesFragment
import com.almulygil.technicalexamtmdb.base.utils.Constants


class MainPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val homeTabFragments: Map<Int, () -> Fragment> = mapOf(
        Constants.POPULAR_MOVIE_INDEX to { PopularMoviesFragment() },
        Constants.PROFILE_MOVIE_INDEX to { ProfileMoviesFragment() }
    )

    override fun getItemCount() = homeTabFragments.size

    override fun createFragment(position: Int): Fragment {
        return homeTabFragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}