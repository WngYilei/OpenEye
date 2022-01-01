package com.xl.openeye.ui.discover.information

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.xl.openeye.R
import com.xl.openeye.databinding.FragmentInfoMationBinding
import com.xl.openeye.itemcell.NewsInfomationItem
import com.xl.openeye.itemcell.NewsTextItem
import com.xl.openeye.itemcell.SpecialItem
import com.xl.openeye.ui.discover.DiscoverViewModel
import com.xl.openeye.ui.discover.flow.FllowFragment
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.StableAdapter
import com.xl.xl_base.adapter.recycler.createStableAdapter
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.onSmartRefreshCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoMationFragment :
    BaseFragment<FragmentInfoMationBinding>(FragmentInfoMationBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() =
            InfoMationFragment()
    }

    val viewModel: DiscoverViewModel by viewModels()


    private lateinit var recyclerAdapter: StableAdapter
    private var num: Int = 0

    override fun onFragmentCreate(savedInstanceState: Bundle?) {

        viewBinding.smartRefresh.onSmartRefreshCallback {
            onRefresh {
                num = 0
                viewModel.getNewInfo(num)
            }
            onLoadMore {
                num++
                viewModel.getNewInfo(num)
            }
        }

        viewBinding.smartRefresh.autoRefresh()

        recyclerAdapter = createStableAdapter {
            imageLoader = ImageLoader(this@InfoMationFragment)
        }


        viewBinding.recycle.apply {
            adapter = recyclerAdapter
            layoutManager =
                LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
        }

        viewModel.state.collectHandlerFlow(this) { state ->
            state.newsInfo?.let { it ->
                viewBinding.smartRefresh.finishRefresh()
                viewBinding.smartRefresh.finishLoadMore()

                val items = mutableListOf<ItemCell>()
                it.itemList.forEach {
                    if (it.type == "textCard")
                        items.add(NewsTextItem(it.data.text))
                    else items.add(NewsInfomationItem(it))
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items, state.refresh)
                }
            }
        }
    }
}