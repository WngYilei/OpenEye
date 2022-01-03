package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.Data
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.util.DateUtil
import kotlinx.android.synthetic.main.item_video_text.view.*

class VideoTextItem(val data: Data) : ItemCell {
    override fun itemContent() = "VideoTextItem"
    override fun itemId() = "$data"

    override fun layoutResId() = R.layout.item_video_text

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        VideoTextHolder(itemView, support)


    class VideoTextHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as VideoTextItem
            itemView.item_videdetail_title.text = cell.data.title

            itemView.item_videodetail_type.text = "#" + cell.data.type + "/" + DateUtil.format(
                cell.data.author.latestReleaseTime,
                "yyyy/mm/dd HH:mm"
            )
            itemView.item_videdetail_description.text = cell.data.description
            itemView.item_video_text_like.text = cell.data.consumption.collectionCount.toString()
            itemView.item_video_text_share.text = cell.data.consumption.shareCount.toString()
            itemView.item_video_text_comment.text = cell.data.consumption.replyCount.toString()

            itemView.item_video_text_auther_name.text = cell.data.author.name
            itemView.item_video_text_auther_description.text = cell.data.author.description


            support.imageLoader?.display(
                itemView.item_video_text_auther_heard,
                cell.data.author.icon
            )
        }
    }

}