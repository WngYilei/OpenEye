package com.xl.openeye.ui.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hjq.bar.OnTitleBarListener
import com.hjq.bar.TitleBar
import com.xl.openeye.App
import com.xl.openeye.databinding.HomeFragmentBinding
import com.xl.openeye.dataclass.Data
import com.xl.openeye.itemcell.BannerItem
import com.xl.openeye.itemcell.HomeVideoItem
import com.xl.openeye.itemcell.TextHeaderItem
import com.xl.openeye.state.ViewEvent
import com.xl.openeye.ui.search.SearchActivity
import com.xl.openeye.ui.video.VideoDetailActivity
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.*
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.dp
import com.xl.xl_base.tool.ktx.goActivity
import com.xl.xl_base.tool.ktx.onSmartRefreshCallback
import com.xl.xl_base.tool.util.StringUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var bannerAdapter: StableAdapter
    private lateinit var recyclerAdapter: StableAdapter
    private var date: String = ""
    override fun onFragmentCreate(savedInstanceState: Bundle?) {

        viewBinding.titlebar.setOnTitleBarListener(object : OnTitleBarListener {
            override fun onRightClick(titleBar: TitleBar?) {
                goActivity(SearchActivity::class.java)
            }
        })

        viewBinding.smartRefresh.autoRefresh()

        viewBinding.smartRefresh.onSmartRefreshCallback {
            onRefresh {
                viewModel.submitAction(ViewEvent.Refresh)
            }
            onLoadMore {
                viewModel.getNextHome(date)
            }
        }

        recyclerAdapter = createStableAdapter {
            imageLoader = ImageLoader(this@HomeFragment)
            onDetailClickCallback { _, _, value ->
                val data = value as Data
                App.data = data
                goActivity(VideoDetailActivity::class.java)
            }
        }

        bannerAdapter = createStableAdapter {
            imageLoader = ImageLoader(this@HomeFragment)
            onDetailClickCallback { _, _, value ->
                val data = value as Data
                App.data = data
                goActivity(VideoDetailActivity::class.java)
            }
        }

        viewBinding.recycle.apply {
            adapter = AdapterConfig.createNo(bannerAdapter, recyclerAdapter)
            layoutManager =
                LinearLayoutManager(context).apply {
                    orientation = LinearLayoutManager.VERTICAL
                }
            addItemDecoration(
                GridDividerItemDecoration(
                    0,
                    0.5.dp, Color.parseColor("#EEEEEE")
                )
            )
        }


        viewModel.state.collectHandlerFlow(this) { state ->

            state.homeInfo?.let { it ->
                viewBinding.smartRefresh.finishRefresh()
                viewBinding.smartRefresh.finishLoadMore()

                val map = StringUtils.getUrl(it.nextPageUrl)
                date = map["date"]!!
                val items = mutableListOf<ItemCell>()


                val itemBanner = mutableListOf<ItemCell>()
                itemBanner.add(
                    BannerItem(
                        activity as AppCompatActivity,
                        it.issueList[0].itemList
                    )
                )
                itemBanner.add(TextHeaderItem("开眼看世界"))
                bannerAdapter.submitList(itemBanner.size, itemBanner, true)


                it.issueList[0].itemList.forEach {
                    if (it.type == "video") {
                        items.add(HomeVideoItem(it.data))
                    } else if (it.type == "textHeader") {
                        items.add(TextHeaderItem(it.data.text))
                    }
                }
                it.issueList[0].itemList.size?.let {
                    recyclerAdapter.submitList(it, items, state.refresh)
                }
            }
        }

    }

}