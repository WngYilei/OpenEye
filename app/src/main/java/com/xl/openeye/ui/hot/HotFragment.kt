package com.xl.openeye.ui.hot

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.xl.openeye.R
import com.xl.openeye.adapter.FragmentAdapter
import com.xl.openeye.databinding.HotFragmentBinding
import com.xl.openeye.ui.discover.flow.FllowFragment
import com.xl.openeye.ui.discover.information.InfoMationFragment
import com.xl.openeye.ui.discover.recommend.RecommendFragment
import com.xl.openeye.ui.discover.special.SpecialFragment
import com.xl.openeye.ui.discover.type.TypeFragment
import com.xl.xl_base.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotFragment : BaseFragment<HotFragmentBinding>(HotFragmentBinding::inflate) {

    private val fragments = arrayListOf<Fragment>()
    private val tabs = arrayListOf("周排行", "月排行", "总排行")

    init {
        fragments.add(WeekRankingFragment.newInstance())
        fragments.add(MonthRankingFragment.newInstance())
        fragments.add(TotalRankingFragment.newInstance())
    }


    companion object {
        fun newInstance() = HotFragment()
    }

    private val viewModel: HotViewModel by viewModels()
    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        val fragmentAdapter = FragmentAdapter(childFragmentManager, lifecycle, fragments)
        viewBinding.viewPager.adapter = fragmentAdapter

        TabLayoutMediator(
            viewBinding.tabLayout,
            viewBinding.viewPager
        ) { tab, position ->
            tab.text = tabs[position]
        }.attach()

    }

}