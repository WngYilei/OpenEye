package com.xl.openeye.itemcell

import android.view.View
import com.xl.openeye.R
import com.xl.openeye.dataclass.RankingData
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.RecyclerSupport
import com.xl.xl_base.adapter.recycler.RecyclerVH
import com.xl.xl_base.tool.util.DateUtil
import kotlinx.android.synthetic.main.item_ranking_video.view.*
import kotlinx.android.synthetic.main.item_ranking_video.view.item_img_author
import kotlinx.android.synthetic.main.item_ranking_video.view.item_tv_video_description

class RankingItem(var rankingData: RankingData) : ItemCell {
    override fun itemContent() = "RankingVideoItem"
    override fun itemId() = "$rankingData"
    override fun layoutResId() = R.layout.item_ranking_video
    override fun onCreateViewHolder(itemView: View, support: RecyclerSupport): RecyclerVH =
        RankingHolder(itemView, support)

    class RankingHolder(itemView: View, support: RecyclerSupport) :
        RecyclerVH(itemView, support) {
        override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
            val cell = itemCell as RankingItem
            itemView.item_ranking_video_type.text = cell.rankingData.category

            itemView.item_ranking_video_time.text =   DateUtil.format(cell.rankingData.duration * 1000.toLong(),"HH:mm")
            itemView.item_ranking_video_title.text = cell.rankingData.title
            itemView.item_tv_video_description.text = cell.rankingData.author.name

            support.imageLoader?.display(
                itemView.item_img_ranking_video,
                cell.rankingData.cover.feed,
                centerCrop = true,
                radius = 20
            )

            support.imageLoader?.displayAvatar(
                itemView.item_img_author,
                cell.rankingData.author.icon,
            )
        }
    }
}