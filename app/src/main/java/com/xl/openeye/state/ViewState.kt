package com.xl.openeye.state

import com.xl.openeye.dataclass.*

data class ViewState(
    var isFirst: Boolean = false,
    val loading: Boolean = false,
    val refresh: Boolean = false,
    var homeInfo: HomeInfo? = null,
    var followInfo: FollowInfo? = null,
    var categoryInfo: List<CategoryInfoItem>? = null,
    var toppics: Toppics? = null,
    var newsInfo: NewsInfo? = null,
    var recommendInfo: RecommendInfo? = null,
    var rankingInfo: RankingInfo? = null
)
