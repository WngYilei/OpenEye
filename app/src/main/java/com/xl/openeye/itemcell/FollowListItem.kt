package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.Item
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.ktx.toPx
import com.xl.xl_base.tool.util.DateUtil
import kotlinx.android.synthetic.main.item_follow_list.view.*

class FollowListItem(var item: Item) : ItemCell {
    override fun itemContent() = "FollowListItem"
    override fun itemId() = "$item"

    override fun layoutResId() = R.layout.item_follow_list
    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        FollowListHolder(itemView, support)

    class FollowListHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as FollowListItem

            itemView.item_follow_list_time.text = DateUtil.format(cell.item.data.duration*1000.toLong(),"HH:mm")
            itemView.item_follow_list_name.text = cell.item.data.title
            itemView.item_follow_list_type.text = cell.item.data.category

            support.imageLoader?.display(itemView.item_follow_list_img,cell.item.data.cover.feed, centerCrop = true, radius = 8.toPx())
        }
    }
}