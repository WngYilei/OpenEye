package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.NewItem
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import kotlinx.android.synthetic.main.item_newinfotion_msg.view.*
import kotlinx.android.synthetic.main.item_textheader.view.*
import kotlinx.android.synthetic.main.item_textheader.view.item_tv_header

class NewsInfomationMsgItem(val title: String) : ItemCell {
    override fun itemContent() = "NewsInfomationMsgItem"

    override fun itemId() = "$title"

    override fun layoutResId() = R.layout.item_newinfotion_msg
    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        NewsInfomationMsgHolder(itemView, support)


    class NewsInfomationMsgHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as NewsInfomationMsgItem
            itemView.item_newinfomationmsg_msg.text = cell.title
        }
    }
}