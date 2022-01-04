package com.xl.openeye.itemcell

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xl.openeye.R
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import kotlinx.android.synthetic.main.item_banner.view.*
import com.bumptech.glide.Glide
import com.xl.openeye.dataclass.Item


import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator


class BannerItem(val activity: AppCompatActivity, val itemList: List<Item>) : ItemCell {
    override fun itemContent() = "BannerItem"

    override fun itemId() = "BannerItem"

    override fun layoutResId() = R.layout.item_banner

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        BannerHolder(itemView, support)


    class BannerHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as BannerItem

            itemView.banner.addBannerLifecycleObserver(cell.activity)
                .setAdapter(object : BannerImageAdapter<Item>(cell.itemList) {
                    override fun onBindView(
                        holder: BannerImageHolder,
                        data: Item,
                        position: Int,
                        size: Int
                    ) {
                        Glide.with(cell.activity)
                            .load(if (data.data.cover == null) R.mipmap.test else data.data.cover.feed)
                            .into(holder.imageView)
                    }
                }).indicator = CircleIndicator(cell.activity)
            itemView.banner.setOnBannerListener { any, position ->
                support.detailClickCallback?.invoke(position, 0, cell.itemList[position].data)
            }
        }
    }


}