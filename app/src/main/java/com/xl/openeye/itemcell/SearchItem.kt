package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.Item
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.util.DateUtil
import kotlinx.android.synthetic.main.item_search.view.*

class SearchItem(var item: Item) : ItemCell {
    override fun itemContent() ="$item"
    override fun itemId() = "$item"
    override fun layoutResId() = R.layout.item_search
    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport) =
        SearchItemHolder(itemView, support)

    class SearchItemHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as SearchItem
            support.imageLoader?.display(itemView.item_search_img, cell.item.data.cover?.feed)
            itemView.item_search_title.text = cell.item.data.title
            itemView.item_search_img.setOnClickListener {
                support.detailClickCallback?.invoke(layoutPosition, 0, cell.item.data)
            }
        }
    }
}