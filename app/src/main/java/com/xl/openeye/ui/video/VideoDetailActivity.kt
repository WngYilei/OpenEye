package com.xl.openeye.ui.video

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.xl.openeye.App
import com.xl.openeye.databinding.ActivityVideoDetailBinding
import com.xl.openeye.itemcell.TextHeaderItem
import com.xl.openeye.itemcell.VideoRecommendItem
import com.xl.openeye.itemcell.VideoTextItem
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.AdapterConfig
import com.xl.xl_base.adapter.recycler.RecyclerAdapter
import com.xl.xl_base.adapter.recycler.createAdapter
import com.xl.xl_base.base.BaseActivity
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import dagger.hilt.android.AndroidEntryPoint
import cn.jzvd.Jzvd
import com.bumptech.glide.Glide
import com.xl.openeye.dataclass.Data
import com.xl.openeye.itemcell.VideoTextHeaderItem
import com.xl.xl_base.tool.ktx.goActivity


@AndroidEntryPoint
class VideoDetailActivity :
    BaseActivity<ActivityVideoDetailBinding>(ActivityVideoDetailBinding::inflate) {
    val viewModel: VideoDetailViewModel by viewModels()

    lateinit var recyclerAdapter: RecyclerAdapter
    val items = mutableListOf<ItemCell>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerAdapter = createAdapter {
            imageLoader = ImageLoader(this@VideoDetailActivity)
            onDetailClickCallback { position, type, value ->
                App.data = value as Data
                goActivity(VideoDetailActivity::class.java)
            }
        }
        Jzvd.setVideoImageDisplayType(Jzvd.VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP)
        App.data?.let {
            viewBinding.video.setUp(it.playUrl, it.title)
            viewBinding.video.startVideo()
            viewModel.getVideoRecommend(it.id.toString())
            items.add(VideoTextItem(it))
            Glide.with(this).load(it.cover.blurred + "/thumbnail/1920x1080").fitCenter()
                .into(viewBinding.img)
        }
        viewBinding.recycle.apply {
            adapter = AdapterConfig.createNo(recyclerAdapter)
            layoutManager = LinearLayoutManager(context)
        }


        viewModel.state.collectHandlerFlow(this) { state ->
            state.videoRecommendInfo?.let { it ->
                it.itemList.forEach {
                    if (it.type == "textCard") {
                        items.add(VideoTextHeaderItem(it.data.text))
                    } else {
                        items.add(VideoRecommendItem(it.data))
                    }
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items)
                }
            }
        }
    }

    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }
}