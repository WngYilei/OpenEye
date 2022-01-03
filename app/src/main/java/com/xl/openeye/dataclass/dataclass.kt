package com.xl.openeye.dataclass

data class HomeInfo(
    val dialog: Any,
    val issueList: List<Issue>,
    val newestIssueType: String,
    val nextPageUrl: String,
    val nextPublishTime: Long
)

data class Issue(
    val count: Int,
    val date: Long,
    val itemList: List<Item>,
    val publishTime: Long,
    val releaseTime: Long,
    val type: String
)

data class Item(
    val adIndex: Int,
    val `data`: Data,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class Data(
    val actionUrl: String,
    val ad: Boolean,
    val adTrack: Any,
    val author: Author,
    val autoPlay: Boolean,
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
    val header: Header,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val image: String,
    val label: Any,
    val labelList: Any,
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
    val remark: Any,
    val resourceType: String,
    val searchWeight: Int,
    val shade: Boolean,
    val shareAdTrack: Any,
    val slogan: String,
    val src: Any,
    val subtitles: List<Any>,
    val tags: List<Tag>,
    val thumbPlayUrl: String,
    val title: String,
    val titlePgc: String,
    val type: String,
    val text: String,
    val videoPosterBean: Any,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl,

    val count: Int,

    val footer: Any,

    val itemList: List<Item>
)

data class Header(
    val actionUrl: String,
    val adTrack: Any,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val iconType: String,
    val id: Int,
    val ifPgc: Boolean,
    val ifShowNotificationIcon: Boolean,
    val subTitle: Any,
    val title: String,
    val uid: Int
)


data class Author(
    val adTrack: Any,
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val link: String,
    val name: String,
    val recSort: Int,
    val shield: Shield,
    val videoNum: Int
)

data class Consumption(
    val collectionCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
)

data class Cover(
    val blurred: String,
    val detail: String,
    val feed: String,
    val homepage: String,
    val sharing: Any
)

data class PlayInfo(
    val height: Int,
    val name: String,
    val type: String,
    val url: String,
    val urlList: List<Url>,
    val width: Int
)

data class Provider(
    val alias: String,
    val icon: String,
    val name: String
)

data class Tag(
    val actionUrl: String,
    val adTrack: Any,
    val bgPicture: String,
    val childTagIdList: Any,
    val childTagList: Any,
    val communityIndex: Int,
    val desc: String,
    val haveReward: Boolean,
    val headerImage: String,
    val id: Int,
    val ifNewest: Boolean,
    val name: String,
    val newestEndTime: Any,
    val tagRecType: String
)

data class WebUrl(
    val forWeibo: String,
    val raw: String
)

data class Follow(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)

data class Shield(
    val itemId: Int,
    val itemType: String,
    val shielded: Boolean
)

data class Url(
    val name: String,
    val size: Int,
    val url: String
)


data class CategoryInfoItem(
    val alias: Any,
    val bgColor: String,
    val bgPicture: String,
    val defaultAuthorId: Int,
    val description: String,
    val headerImage: String,
    val id: Int,
    val name: String,
    val tagId: Int
)



data class Toppics(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<ToppocItem>,
    val nextPageUrl: String,
    val total: Int
)

data class ToppocItem(
    val adIndex: Int,
    val `data`: ToppicData,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class ToppicData(
    val actionUrl: String,
    val adTrack: List<Any>,
    val autoPlay: Boolean,
    val dataType: String,
    val description: String,
    val header: Any,
    val id: Int,
    val image: String,
    val label: Label,
    val labelList: List<Any>,
    val shade: Boolean,
    val title: String
)

data class Label(
    val card: String,
    val detail: Any,
    val text: String
)




data class NewsInfo(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<NewItem>,
    val nextPageUrl: String,
    val total: Int
)

data class NewItem(
    val adIndex: Int,
    val `data`: NewData,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class NewData(
    val actionUrl: Any,
    val adTrack: Any,
    val backgroundImage: String,
    val bannerList: List<Banner>,
    val dataType: String,
    val follow: Any,
    val headerType: String,
    val id: Int,
    val startTime: Long,
    val subTitle: Any,
    val text: String,
    val titleList: List<String>,
    val type: String
)

data class Banner(
    val background_image: String,
    val link: String,
    val poster_image: String,
    val tag_name: String,
    val title: String
)



data class RecommendInfo(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<RecommendItem>,
    val nextPageUrl: String,
    val total: Int
)

data class RecommendItem(
    val adIndex: Int,
    val `data`: RecommendData,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class RecommendData(
    val adTrack: Any,
    val content: Content,
    val dataType: String,
    val header: RecommendHeader
)

data class Content(
    val adIndex: Int,
    val `data`: RecommendDataX,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class RecommendHeader(
    val actionUrl: String,
    val followType: String,
    val icon: String,
    val iconType: String,
    val id: Int,
    val issuerName: String,
    val labelList: Any,
    val showHateVideo: Boolean,
    val tagId: Int,
    val tagName: Any,
    val time: Long,
    val topShow: Boolean
)

data class RecommendDataX(
    val addWatermark: Boolean,
    val area: String,
    val checkStatus: String,
    val city: String,
    val collected: Boolean,
    val consumption: Consumption,
    val cover: Cover,
    val createTime: Long,
    val dataType: String,
    val description: String,
    val duration: Int,
    val height: Int,
    val id: Int,
    val ifMock: Boolean,
    val latitude: Double,
    val library: String,
    val longitude: Double,
    val owner: Owner,
    val playUrl: String,
    val playUrlWatermark: String,
    val privateMessageActionUrl: Any,
    val reallyCollected: Boolean,
    val recentOnceReply: RecentOnceReply,
    val releaseTime: Long,
    val resourceType: String,
    val selectedTime: Any,
    val source: String,
    val status: Any,
    val tags: List<Tag>,
    val title: String,
    val transId: Any,
    val type: String,
    val uid: Int,
    val updateTime: Long,
    val url: String,
    val urls: List<String>,
    val urlsWithWatermark: List<String>,
    val validateResult: String,
    val validateStatus: String,
    val validateTaskId: String,
    val width: Int
)



data class Owner(
    val actionUrl: String,
    val area: Any,
    val avatar: String,
    val birthday: Long?,
    val city: String,
    val country: String,
    val cover: Any,
    val description: String,
    val expert: Boolean,
    val followed: Boolean,
    val gender: String,
    val ifPgc: Boolean,
    val job: String,
    val library: String,
    val limitVideoOpen: Boolean,
    val nickname: String,
    val registDate: Long,
    val releaseDate: Long,
    val uid: Int,
    val university: String,
    val userType: String
)

data class RecentOnceReply(
    val actionUrl: String,
    val contentType: Any,
    val dataType: String,
    val message: String,
    val nickname: String
)



data class RankingInfo(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<RankingItem>,
    val nextPageUrl: Any,
    val total: Int
)

data class RankingItem(
    val adIndex: Int,
    val `data`: RankingData,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class RankingData(
    val ad: Boolean,
    val adTrack: List<Any>,
    val author: RankingAuthor,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val category: String,
    val collected: Boolean,
    val consumption: RankingConsumption,
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
    val remark: Any,
    val resourceType: String,
    val searchWeight: Int,
    val shareAdTrack: Any,
    val slogan: String,
    val src: Any,
    val subtitles: List<Any>,
    val tags: List<Tag>,
    val thumbPlayUrl: String,
    val title: String,
    val titlePgc: String,
    val type: String,
    val videoPosterBean: Any,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl
)

data class RankingAuthor(
    val adTrack: Any,
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val link: String,
    val name: String,
    val recSort: Int,
    val shield: Shield,
    val videoNum: Int
)

data class RankingConsumption(
    val collectionCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
)



