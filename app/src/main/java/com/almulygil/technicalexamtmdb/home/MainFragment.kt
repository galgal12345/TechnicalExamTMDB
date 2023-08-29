package com.almulygil.technicalexamtmdb.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.google.android.material.tabs.TabLayoutMediator


import com.almulygil.technicalexamtmdb.base.utils.Constants
import com.almulygil.technicalexamtmdb.base.utils.UtilityClass
import com.almulygil.technicalexamtmdb.databinding.FragmentMainBinding


class MainFragment : Fragment() {


    private lateinit var binding: FragmentMainBinding
    private var listener: HomeCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        configureListener(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                listener?.onBackPressedFromHome()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun configureListener(context: Context) {
        listener = UtilityClass.getParent(this, HomeCallback::class.java)
        if (listener == null) {
            throw ClassCastException(
                StringBuilder(context.javaClass.simpleName).append("must implement")
                    .append(MainFragment::class.java.simpleName).toString()
            )
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.pager.adapter = MainPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            Constants.POPULAR_MOVIE_INDEX -> "Home"
            Constants.PROFILE_MOVIE_INDEX -> "My Favorites"
            else -> null
        }
    }

    interface HomeCallback {
        fun onBackPressedFromHome()
    }


}