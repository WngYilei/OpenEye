package com.xl.openeye.itemcell

import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.xl.openeye.R
import com.xl.openeye.dataclass.RecommendItem
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.ktx.toPx
import kotlinx.android.synthetic.main.item_recommend_photo.view.*

class RecommendPhotoItem(val recommendItem: RecommendItem) : ItemCell {
    override fun itemContent() = "ItemRecommendPhoto"

    override fun itemId() = "$recommendItem"
    override fun layoutResId() = R.layout.item_recommend_photo

    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        ItemRecommendHolder(itemView, support)

    class ItemRecommendHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as RecommendPhotoItem


            val params = itemView.item_recommend_photo.layoutParams
            params.height = cell.recommendItem.data.content.data.height+100f.toPx()
            params.width = cell.recommendItem.data.content.data.width
            itemView.item_recommend_photo.layoutParams = params


            Glide.with(itemView).load(cell.recommendItem.data.content.data.cover.feed).override(
                cell.recommendItem.data.content.data.width,
                cell.recommendItem.data.content.data.height
            ).centerInside().into(itemView.item_recommend_photo)


            support.imageLoader?.displayAvatar(
                itemView.item_recommend_heard,
                cell.recommendItem.data.content.data.owner.avatar
            )

            itemView.item_recommend_description.text =
                cell.recommendItem.data.content.data.description

            itemView.item_recommend_nickname.text =
                cell.recommendItem.data.content.data.owner.nickname

            itemView.item_recommend_zan.text =
                cell.recommendItem.data.content.data.consumption.collectionCount.toString()
        }
    }
}