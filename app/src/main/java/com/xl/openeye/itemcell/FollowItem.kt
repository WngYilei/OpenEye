package com.xl.openeye.itemcell

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xl.openeye.R
import com.xl.openeye.dataclass.Item
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.adapter.recycler.createAdapter
import kotlinx.android.synthetic.main.item_follow.view.*


class FollowItem(var data: Item) : ItemCell {

    override fun itemContent() = "FollowItem"

    override fun itemId() = "$data"
    override fun layoutResId() = R.layout.item_follow

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        FollowHolder(itemView, support)


    class FollowHolder(itemView: View, support: RecyclerSupport) : RecyclerVH(itemView, support) {

        val recyclerAdapter = createAdapter {
            imageLoader = ImageLoader(itemView.context)
            onDetailClickCallback { position, type, value ->
                support.detailClickCallback?.invoke(position, type, value)
            }
        }

        init {
            itemView.recycle_follow.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = recyclerAdapter
            }
        }

        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as FollowItem
            support.imageLoader?.displayAvatar(
                itemView.item_follow_heard,
                cell.data.data.header.icon
            )
            itemView.item_follow_title.text = cell.data.data.header.title
            itemView.item_follow_description.text = cell.data.data.header.description
            val list = cell.data.data.itemList
            val items = arrayListOf<ItemCell>()
            list.forEach {
                items.add(FollowListItem(it))
            }
            list.size?.let {
                recyclerAdapter.submitList(it, items)
            }
        }
    }
}