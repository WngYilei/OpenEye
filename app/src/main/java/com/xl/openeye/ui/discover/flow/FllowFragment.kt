package com.xl.openeye.ui.discover.flow

import android.os.Bundle

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.xl.openeye.App
import com.xl.openeye.databinding.FragmentFllowBinding
import com.xl.openeye.dataclass.Item
import com.xl.openeye.itemcell.FollowItem
import com.xl.openeye.state.ViewEvent
import com.xl.openeye.ui.discover.DiscoverViewModel
import com.xl.openeye.ui.video.VideoDetailActivity
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.StableAdapter
import com.xl.xl_base.adapter.recycler.createStableAdapter
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.goActivity
import com.xl.xl_base.tool.ktx.onSmartRefreshCallback
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class FllowFragment : BaseFragment<FragmentFllowBinding>(FragmentFllowBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() = FllowFragment()
    }

    val viewModel: DiscoverViewModel by viewModels()


    private lateinit var recyclerAdapter: StableAdapter
    private var num: Int = 0

    override fun onFragmentCreate(savedInstanceState: Bundle?) {


        viewBinding.smartRefresh.autoRefresh()

        viewBinding.smartRefresh.onSmartRefreshCallback {
            onRefresh {
                num = 0
                viewModel.submitAction(ViewEvent.RefreshFollow)
            }
            onLoadMore {
                num++
                viewModel.getFollow(num.toString())
            }
        }

        recyclerAdapter = createStableAdapter {
            imageLoader = ImageLoader(this@FllowFragment)
            onDetailClickCallback { _, _, value ->
                App.data = (value as Item).data
                goActivity(VideoDetailActivity::class.java)
            }
        }


        viewBinding.recycle.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
        }

        viewModel.state.collectHandlerFlow(this) { state ->
            state.followInfo?.let { it ->
                viewBinding.smartRefresh.finishRefresh()
                viewBinding.smartRefresh.finishLoadMore()

                val items = mutableListOf<ItemCell>()
                it.itemList.forEach {
                    items.add(FollowItem(it))
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items, state.refresh)
                }
            }
        }


    }
}