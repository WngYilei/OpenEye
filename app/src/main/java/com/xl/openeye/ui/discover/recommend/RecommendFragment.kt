package com.xl.openeye.ui.discover.recommend

import android.R.attr
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.xl.openeye.databinding.FragmentRecommendBinding
import com.xl.openeye.itemcell.RecommendPhotoItem
import com.xl.openeye.ui.discover.DiscoverViewModel
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.AdapterConfig
import com.xl.xl_base.adapter.recycler.GridDividerItemDecoration
import com.xl.xl_base.adapter.recycler.StableAdapter
import com.xl.xl_base.adapter.recycler.createStableAdapter
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.dp
import com.xl.xl_base.tool.ktx.onSmartRefreshCallback
import dagger.hilt.android.AndroidEntryPoint
import android.R.attr.divider
import android.graphics.Rect
import android.view.View
import androidx.annotation.NonNull

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import android.R.attr.divider


@AndroidEntryPoint
class RecommendFragment :
    BaseFragment<FragmentRecommendBinding>(FragmentRecommendBinding::inflate) {

    companion object {
        fun newInstance() =
            RecommendFragment()
    }

    val viewModel: DiscoverViewModel by viewModels()


    private lateinit var recyclerAdapter: StableAdapter
    private var startScore: String = ""

    override fun onFragmentCreate(savedInstanceState: Bundle?) {


        viewBinding.smartRefresh.autoRefresh()

        viewBinding.smartRefresh.onSmartRefreshCallback {
            onRefresh {

                viewModel.getRecommend("1640770607000")
            }
            onLoadMore {
                viewModel.getRecommend(startScore)
            }
        }

        recyclerAdapter = createStableAdapter {
            imageLoader = ImageLoader(this@RecommendFragment)
        }

        viewBinding.recycle.apply {
            adapter = AdapterConfig.createNo(recyclerAdapter)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        viewModel.state.collectHandlerFlow(this) { state ->

            state.recommendInfo?.let { it ->
                startScore = it.nextPageUrl?.split("?")[1].split("&")[0].split("=")[1]
                viewBinding.smartRefresh.finishRefresh()
                viewBinding.smartRefresh.finishLoadMore()

                val items = mutableListOf<ItemCell>()
                it.itemList.forEach {
                    items.add(RecommendPhotoItem(it))
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items, state.refresh)
                }
            }
        }


    }
}