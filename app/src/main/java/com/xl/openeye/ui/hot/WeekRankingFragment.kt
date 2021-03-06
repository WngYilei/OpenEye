package com.xl.openeye.ui.hot

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.xl.openeye.App
import com.xl.openeye.databinding.FragmentWeekRankingBinding
import com.xl.openeye.dataclass.Data
import com.xl.openeye.itemcell.RankingItem
import com.xl.openeye.state.ViewEvent
import com.xl.openeye.ui.video.VideoDetailActivity
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.AdapterConfig
import com.xl.xl_base.adapter.recycler.GridDividerItemDecoration
import com.xl.xl_base.adapter.recycler.RecyclerAdapter
import com.xl.xl_base.adapter.recycler.createAdapter
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.dp
import com.xl.xl_base.tool.ktx.goActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeekRankingFragment :
    BaseFragment<FragmentWeekRankingBinding>(FragmentWeekRankingBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() = WeekRankingFragment()
    }

    lateinit var recyclerAdapter: RecyclerAdapter
    val viewModel: HotViewModel by viewModels()
    override fun onFragmentCreate(savedInstanceState: Bundle?) {

        recyclerAdapter = createAdapter {
            imageLoader = ImageLoader(this@WeekRankingFragment)
            onDetailClickCallback { _, _, value ->
                App.data = value as Data
                goActivity(VideoDetailActivity::class.java)
            }
        }
        viewModel.submitAction(ViewEvent.RefreshWeekRanking)
        viewBinding.recycle.apply {
            adapter = AdapterConfig.createNo(recyclerAdapter)
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                GridDividerItemDecoration(
                    0,
                    0.5.dp, Color.parseColor("#EEEEEE")
                )
            )
        }

        viewModel.state.collectHandlerFlow(this) { state ->
            state.rankingInfo?.let { it ->
                val items = mutableListOf<ItemCell>()
                it.itemList.forEach {
                    items.add(RankingItem(it.data))
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items)
                }
            }
        }


    }
}