package com.xl.openeye.ui.discover.special

import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.hjq.bar.OnTitleBarListener
import com.hjq.bar.TitleBar

import com.xl.openeye.databinding.ActivitySpecialDetailBinding
import com.xl.openeye.itemcell.FollowItem
import com.xl.openeye.itemcell.SpecialDetailItem
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerAdapter
import com.xl.xl_base.adapter.recycler.StableAdapter
import com.xl.xl_base.adapter.recycler.createAdapter
import com.xl.xl_base.base.BaseActivity
import com.xl.xl_base.tool.ktx.collectHandlerFlow
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
        }


        viewBinding.titlebar.setOnTitleBarListener(object : OnTitleBarListener {
            override fun onLeftClick(titleBar: TitleBar?) {
                finish()
            }
        })
        viewModel.state.collectHandlerFlow(this) { state ->

            state.specialDetailInfo?.let {
                viewBinding.titlebar.title = it.brief
                viewBinding.tvSpecialDetailBrief.text = it.text
                viewBinding.tvSpecialDetailText.text = it.brief
                Glide.with(this).load(it.headerImage).centerInside().into(viewBinding.imgSpecialDetail)

                val items = mutableListOf<ItemCell>()
                it.itemList.forEach {
                    items.add(SpecialDetailItem(it.data))
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items)
                }
            }
        }

    }
}