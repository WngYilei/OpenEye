package com.xl.openeye.ui.discover.recommend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.xl.openeye.R
import com.xl.openeye.databinding.FragmentRecommendBinding
import com.xl.openeye.ui.discover.DiscoverViewModel
import com.xl.xl_base.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecommendFragment : BaseFragment<FragmentRecommendBinding>(FragmentRecommendBinding::inflate) {

    companion object {
        fun newInstance() =
            RecommendFragment()
    }

    val viewModel :DiscoverViewModel by  viewModels()
    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }
}