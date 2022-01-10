package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.ToppocItem
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.ktx.toPx
import kotlinx.android.synthetic.main.item_special.view.*

class SpecialItem(var toppocItem: ToppocItem) : ItemCell {
    override fun itemContent() = "SpecialItem"
    override fun itemId() = "$toppocItem"
    override fun layoutResId() = R.layout.item_special
    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        SpecialHolder(itemView, support)

    class SpecialHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as SpecialItem
            support.imageLoader?.display(
                itemView.item_special_img,
                cell.toppocItem.data.image,
                centerCrop = true,
                radius = 10.toPx()
            )
            itemView.item_special_img.setOnClickListener {
                support.detailViewDataClickCallback?.invoke(
                    layoutPosition,
                    0,
                    itemView.item_special_img,
                    cell.toppocItem.data
                )
            }
        }
    }
}