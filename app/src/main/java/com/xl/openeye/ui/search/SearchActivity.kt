package com.xl.openeye.ui.search

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.hjq.bar.OnTitleBarListener
import com.hjq.bar.TitleBar
import com.xl.openeye.App
import com.xl.openeye.databinding.ActivitySearchBinding
import com.xl.openeye.dataclass.Data
import com.xl.openeye.itemcell.SearchItem
import com.xl.openeye.ui.video.VideoDetailActivity
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.*
import com.xl.xl_base.base.BaseActivity
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.goActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate) {

    val viewModel: SearchViewModel by viewModels()
    private lateinit var recyclerAdapter: StableAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        recyclerAdapter = createStableAdapter {
            imageLoader = ImageLoader(this@SearchActivity)
            onDetailClickCallback { _, _, value ->
                App.data = value as Data
                goActivity(VideoDetailActivity::class.java)
            }
        }

        viewBinding.recycle.apply {
            adapter = AdapterConfig.createNo(recyclerAdapter)
            layoutManager = LinearLayoutManager(context)
        }


        viewBinding.titlebar.setOnTitleBarListener(object : OnTitleBarListener {
            override fun onRightClick(titleBar: TitleBar?) {
                finish()
            }
        })

        viewBinding.etSearch.addTextChangedListener {
            viewModel.getSearch(it.toString())
        }


        viewModel.state.collectHandlerFlow(this) {
            it.searchInfo?.let {
                val items = mutableListOf<ItemCell>()
                it.itemList.forEach { item ->
                    item.data.cover?.let {
                        items.add(SearchItem(item))
                    }
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items, true)
                }

            }

        }
    }
}