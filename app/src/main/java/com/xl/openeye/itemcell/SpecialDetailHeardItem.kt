package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.SpecialDetailInfo
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import kotlinx.android.synthetic.main.item_special_heard_detail.view.*

class SpecialDetailHeardItem(var specialDetailInfo: SpecialDetailInfo) : ItemCell {
    override fun itemContent() = "SpecialDetailHeardItem"

    override fun itemId() = "$specialDetailInfo"

    override fun layoutResId() = R.layout.item_special_heard_detail

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport) =
        SpecialDetailHeardHolder(itemView, support)

    class SpecialDetailHeardHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as SpecialDetailHeardItem
            itemView.tv_special_detail_brief.text = cell.specialDetailInfo.text
            itemView.tv_special_detail_text.text = cell.specialDetailInfo.brief
            support.imageLoader?.display(
                itemView.img_special_detail,
                cell.specialDetailInfo.headerImage
            )
        }
    }
}