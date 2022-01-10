package com.xl.openeye.ui.discover.special

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hjq.bar.OnTitleBarListener
import com.hjq.bar.TitleBar
import com.xl.openeye.App
import com.xl.openeye.databinding.ActivitySpecialDetailBinding
import com.xl.openeye.dataclass.Data
import com.xl.openeye.itemcell.SpecialDetailHeardItem
import com.xl.openeye.itemcell.SpecialDetailItem
import com.xl.openeye.ui.video.VideoDetailActivity
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerAdapter
import com.xl.xl_base.adapter.recycler.createAdapter
import com.xl.xl_base.base.BaseActivity
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.goActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialDetailActivity :
    BaseActivity<ActivitySpecialDetailBinding>(ActivitySpecialDetailBinding::inflate) {

    private lateinit var recyclerAdapter: RecyclerAdapter
    val viewModel: SpecialDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getStringExtra("id")
        id?.let {
            viewModel.getSpecialDetail(id)
        }
        recyclerAdapter = createAdapter {
            imageLoader = ImageLoader(this@SpecialDetailActivity)
            onDetailClickCallback { position, type, value ->
                val data = value as Data
                App.data = data
                goActivity(VideoDetailActivity::class.java)
            }
        }

        viewBinding.recycle.apply {
            adapter = recyclerAdapter
            layoutManager =
                LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
        }


        viewBinding.titlebar.setOnTitleBarListener(object : OnTitleBarListener {
            override fun onLeftClick(titleBar: TitleBar?) {
                finish()
            }
        })


        viewModel.state.collectHandlerFlow(this) { state ->
            state.specialDetailInfo?.let {
                viewBinding.titlebar.title = it.brief
                val items = mutableListOf<ItemCell>()
                items.add(SpecialDetailHeardItem(it))
                it.itemList.forEach {
                    items.add(SpecialDetailItem(it.data))
                }
                recyclerAdapter.submitList(it.itemList.size, items)
            }
        }

    }
}