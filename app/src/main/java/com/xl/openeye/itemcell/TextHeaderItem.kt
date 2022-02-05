package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import kotlinx.android.synthetic.main.item_textheader.view.*

class TextHeaderItem(val text: String) : ItemCell {
    override fun itemContent() = "$text"

    override fun itemId() = "$text"

    override fun layoutResId() = R.layout.item_textheader

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        TextHeaderHolder(itemView, support)


    class TextHeaderHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as TextHeaderItem
            itemView.item_tv_header.text = cell.text
        }
    }
}