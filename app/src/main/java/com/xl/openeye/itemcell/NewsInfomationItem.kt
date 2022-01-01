package com.xl.openeye.itemcell

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.openeye.R
import com.xl.openeye.dataclass.NewItem
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.adapter.recycler.createAdapter

import kotlinx.android.synthetic.main.item_newinfotion.view.*

class NewsInfomationItem(val newItem: NewItem) : ItemCell {
    override fun itemContent() = "NewsInfomationItem"

    override fun itemId() = "$newItem"

    override fun layoutResId() = R.layout.item_newinfotion
    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        NewsInfomationHolder(itemView, support)


    class NewsInfomationHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {

        val recyclerAdapter = createAdapter {

        }

        init {
            itemView.item_newinfomation_recycle.apply {
                layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
                adapter = recyclerAdapter
            }
        }

        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as NewsInfomationItem
            support.imageLoader?.display(
                itemView.item_newinfomation_img,
                cell.newItem.data.backgroundImage,
                radius = 10
            )
            val list = cell.newItem.data.titleList
            val items = arrayListOf<ItemCell>()
            list.forEach {
                items.add(NewsInfomationMsgItem(it))
            }
            recyclerAdapter.submitList(list.size, items)
        }
    }
}