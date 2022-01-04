package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import kotlinx.android.synthetic.main.item_textheader.view.*

class VideoTextHeaderItem(val text: String) : ItemCell {
    override fun itemContent() = "TextHeaderItem"

    override fun itemId() = "$text"

    override fun layoutResId() = R.layout.item_video_textheader

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        VideoTextHeaderHolder(itemView, support)


    class VideoTextHeaderHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as VideoTextHeaderItem
            itemView.item_tv_header.text = "#" + cell.text
        }
    }
}