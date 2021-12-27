package com.xl.openeye.ui.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hjq.bar.OnTitleBarListener
import com.hjq.bar.TitleBar
import com.xl.openeye.databinding.HomeFragmentBinding
import com.xl.openeye.itemcell.HomeVideoItem
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.*
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.dp
import com.xl.xl_base.tool.ktx.onSmartRefreshCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()
    private var page = 0
    private lateinit var bannserAdapter: RecyclerAdapter
    private lateinit var recyclerAdapter: StableAdapter
    override fun onFragmentCreate(savedInstanceState: Bundle?) {

        viewBinding.titlebar.setOnTitleBarListener(object : OnTitleBarListener {
            override fun onRightClick(titleBar: TitleBar?) {
                Log.e("TAG", "onRightClick: ")
            }
        })

        viewBinding.smartRefresh.autoRefresh()

        viewBinding.smartRefresh.onSmartRefreshCallback {
            onRefresh {
                page = 0
                viewModel.getHome(0)
            }
            onLoadMore {
                page += 1
                viewModel.getHome(page)
            }
        }

        recyclerAdapter = createStableAdapter {
            imageLoader = ImageLoader(this@HomeFragment)
        }



        viewBinding.recycle.apply {
            adapter = AdapterConfig.createNo(recyclerAdapter)
            layoutManager =
                LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
            addItemDecoration(
                GridDividerItemDecoration(
                    0,
                    0.5.dp, Color.parseColor("#EEEEEE")
                )
            )
        }

        viewModel.state.collectHandlerFlow(this) {

            viewBinding.smartRefresh.finishRefresh()
            viewBinding.smartRefresh.finishLoadMore()


            it.homeInfo?.let {
                val items = mutableListOf<ItemCell>()
                it.issueList[0].itemList.forEach {
                    if (it.type == "video") {
                        items.add(HomeVideoItem(it.data))
                    }
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items, page == 0)
                }
            }
        }

    }

}