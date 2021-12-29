package com.xl.openeye.dataclass

data class FollowInfo(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val lastStartId: Int,
    val nextPageUrl: String,
    val refreshCount: Int,
    val total: Int,
    val updateTime: Any
)

data class ItemX(
    val adIndex: Int,
    val `data`: DataX,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)
data class DataX(
    val ad: Boolean,
    val adTrack: List<Any>,
    val author: Author,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val category: String,
    val collected: Boolean,
    val consumption: Consumption,
    val cover: Cover,
    val dataType: String,
    val date: Long,
    val description: String,
    val descriptionEditor: String,
    val descriptionPgc: String,
    val duration: Int,
    val favoriteAdTrack: Any,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val label: Any,
    val labelList: List<Any>,
    val lastViewTime: Any,
    val library: String,
    val playInfo: List<PlayInfo>,
    val playUrl: String,
    val played: Boolean,
    val playlists: Any,
    val promotion: Any,
    val provider: Provider,
    val reallyCollected: Boolean,
    val recallSource: Any,
    val recall_source: Any,
    val releaseTime: Long,
    val remark: String,
    val resourceType: String,
    val searchWeight: Int,
    val shareAdTrack: Any,
    val slogan: Any,
    val src: Any,
    val subtitles: List<Any>,
    val tags: List<Tag>,
    val thumbPlayUrl: Any,
    val title: String,
    val titlePgc: String,
    val type: String,
    val videoPosterBean: Any,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl
)





data class FollowX(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)


