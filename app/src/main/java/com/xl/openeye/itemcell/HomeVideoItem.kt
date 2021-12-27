package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.Data
import com.xl.openeye.utils.TimeFormatUtils
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import kotlinx.android.synthetic.main.item_home_video.view.*

class HomeVideoItem(val data: Data) : ItemCell {
    override fun itemContent() = "$data"
    override fun itemId() = "HomeVideoItem"

    override fun layoutResId(): Int = R.layout.item_home_video

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        HomeVideoHolder(itemView, support)

    class HomeVideoHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as HomeVideoItem
            itemView.item_tv_video_type.text = cell.data.category
            itemView.item_tv_video_time.text = TimeFormatUtils.getHHmm(cell.data.duration * 1000)
            itemView.item_tv_video_title.text = cell.data.title
            itemView.item_tv_video_description.text = cell.data.author.name

            support.imageLoader?.display(
                itemView.item_img_home_video,
                cell.data.cover.feed,
                centerCrop = true,
                radius = 20
            )

            support.imageLoader?.displayAvatar(
                itemView.item_img_author,
                if (cell.data.author == null) cell.data.provider.icon else cell.data.author.icon,
            )
        }
    }
}