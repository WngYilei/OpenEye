package com.xl.openeye.ui.discover

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.xl.openeye.R
import com.xl.openeye.adapter.FragmentAdapter
import com.xl.openeye.databinding.DiscoverFragmentBinding
import com.xl.openeye.databinding.ItemTabMainBinding
import com.xl.openeye.ui.discover.flow.FllowFragment
import com.xl.openeye.ui.discover.information.InfoMationFragment
import com.xl.openeye.ui.discover.recommend.RecommendFragment
import com.xl.openeye.ui.discover.special.SpecialFragment
import com.xl.openeye.ui.discover.type.TypeFragment
import com.xl.openeye.ui.hot.HotFragment
import com.xl.openeye.ui.me.MeFragment
import com.xl.xl_base.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : BaseFragment<DiscoverFragmentBinding>(DiscoverFragmentBinding::inflate) {
    private val fragments = arrayListOf<Fragment>()
    private val tabs = arrayListOf("关注", "分类", "专题", "资讯", "推荐")

    init {
        fragments.add(FllowFragment.newInstance())
        fragments.add(TypeFragment.newInstance())
        fragments.add(SpecialFragment.newInstance())
        fragments.add(InfoMationFragment.newInstance())
        fragments.add(RecommendFragment.newInstance())
    }

    companion object {
        fun newInstance() = DiscoverFragment()
    }

    private val viewModel: DiscoverViewModel by viewModels()


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