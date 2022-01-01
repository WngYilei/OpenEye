package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import kotlinx.android.synthetic.main.item_newtext.view.*

class NewsTextItem(var text: String) : ItemCell {
    override fun itemContent() = "NewsTextItem"

    override fun itemId() = "$text"
    override fun layoutResId() = R.layout.item_newtext

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        NewsTextHolder(itemView, support)


    class NewsTextHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as NewsTextItem
            itemView.item_newtext.text = cell.text
        }
    }
}