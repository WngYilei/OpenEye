package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.SpecialDetailData
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.ktx.toPx
import com.xl.xl_base.tool.util.DateUtil
import kotlinx.android.synthetic.main.item_special_detail.view.*


class SpecialDetailItem(var data: SpecialDetailData) : ItemCell {
    override fun itemContent() = "SpecialDetailItem"

    override fun itemId() = "$data"
    override fun layoutResId() = R.layout.item_special_detail

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport) =
        SpecialDetailHolder(itemView, support)

    class SpecialDetailHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as SpecialDetailItem
            support.imageLoader?.displayAvatar(
                itemView.img_special_detail_item_heard,
                cell.data.header.icon,
            )
            support.imageLoader?.display(
                itemView.item_img_ranking_video,
                cell.data.content.data.cover.feed,
                radius = 5f.toPx()
            )

            itemView.item_img_ranking_video.setOnClickListener {
                support.detailClickCallback?.invoke(layoutPosition, 0, cell.data.content.data)
            }

            itemView.tv_special_detail_item_name.text = cell.data.header.issuerName
            itemView.tv_special_detail_item_time.text = cell.data.header.time.toString() + "发布："
            itemView.tv_special_detail_item_title.text = cell.data.content.data.title
            itemView.item_ranking_video_time.text =
                DateUtil.format(cell.data.content.data.duration * 1000.toLong(), "HH:mm")
        }
    }
}