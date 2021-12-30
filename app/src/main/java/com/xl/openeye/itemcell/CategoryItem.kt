package com.xl.openeye.itemcell

import android.util.Log
import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.CategoryInfoItem
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.ktx.toPx
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryItem(var categoryInfoItem: CategoryInfoItem) : ItemCell {
    override fun itemContent() = "CategoryItem"
    override fun itemId() = "$categoryInfoItem"

    override fun layoutResId() = R.layout.item_category

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        CategoryHolder(itemView, support)

    class CategoryHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as CategoryItem
            itemView.item_type_text.text = "#" + cell.categoryInfoItem.name
            support.imageLoader?.display(
                itemView.item_type_img,
                cell.categoryInfoItem.bgPicture,
                centerCrop = true,
                radius = 10.toPx()
            )
        }
    }
}