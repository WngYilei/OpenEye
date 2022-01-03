package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.Data
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.ktx.toPx
import com.xl.xl_base.tool.util.DateUtil
import kotlinx.android.synthetic.main.item_video_recommend.view.*

class VideoRecommendItem(val data: Data) : ItemCell {
    override fun itemContent() = "VideoRecommendItem"
    override fun itemId() = "$data"

    override fun layoutResId() = R.layout.item_video_recommend
    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        VideoRecommendHolder(itemView, support)


    class VideoRecommendHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as VideoRecommendItem
            itemView.item_video_recommend_title.text = cell.data.title
            itemView.item_video_recommend_type.text =
                "#${cell.data.type} / ${cell.data.author?.name}"
            itemView.item_video_recommend_time.text =
                DateUtil.format(cell.data.duration * 1000.toLong(), "HH:mm")

            support.imageLoader?.display(
                itemView.item_video_recommend_img,
                cell.data.cover.detail,
                radius = 7f.toPx()
            )
            itemView.item_video_recommend_img.setOnClickListener {
                support.detailClickCallback?.invoke(layoutPosition, 0, cell.data)
            }

        }
    }

}