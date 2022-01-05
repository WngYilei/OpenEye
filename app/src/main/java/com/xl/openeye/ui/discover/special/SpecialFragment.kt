package com.xl.openeye.ui.discover.special


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.xl.openeye.App
import com.xl.openeye.databinding.FragmentSpecialBinding
import com.xl.openeye.dataclass.Data
import com.xl.openeye.itemcell.SpecialItem
import com.xl.openeye.ui.discover.DiscoverViewModel
import com.xl.openeye.ui.video.VideoDetailActivity
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.*
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.dp
import com.xl.xl_base.tool.ktx.goActivity
import com.xl.xl_base.tool.ktx.onSmartRefreshCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialFragment : BaseFragment<FragmentSpecialBinding>(FragmentSpecialBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() = SpecialFragment()
    }

    val viewModel: DiscoverViewModel by viewModels()


    private lateinit var recyclerAdapter: StableAdapter
    private var num: Int = 0

    override fun onFragmentCreate(savedInstanceState: Bundle?) {


        viewBinding.smartRefresh.onSmartRefreshCallback {
            onRefresh {
                num = 0
                viewModel.getToppoc(num)
            }
            onLoadMore {
                num++
                viewModel.getToppoc(num)
            }
        }

        viewBinding.smartRefresh.autoRefresh()

        recyclerAdapter = createStableAdapter {
            imageLoader = ImageLoader(this@SpecialFragment)
            onDetailClickCallback { position, type, value ->
                val data = value as Data
                goActivity(SpecialDetailActivity::class.java, ("id" to data.id.toString()))
            }
        }


        viewBinding.recycle.apply {
            adapter = recyclerAdapter
            layoutManager =
                LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
        }

        viewModel.state.collectHandlerFlow(this) { state ->
            state.toppics?.let { it ->
                viewBinding.smartRefresh.finishRefresh()
                viewBinding.smartRefresh.finishLoadMore()

                val items = mutableListOf<ItemCell>()
                it.itemList.forEach {
                    items.add(SpecialItem(it))
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items, state.refresh)
                }
            }
        }
    }
}