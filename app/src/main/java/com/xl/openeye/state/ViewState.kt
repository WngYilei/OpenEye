package com.xl.openeye.state

import com.xl.openeye.dataclass.CategoryInfoItem
import com.xl.openeye.dataclass.FollowInfo
import com.xl.openeye.dataclass.HomeInfo
import com.xl.openeye.dataclass.Toppics

data class ViewState(
    var isFirst: Boolean = false,
    val loading: Boolean = false,
    val refresh: Boolean = false,
    var homeInfo: HomeInfo? = null,
    var followInfo: FollowInfo? = null,
    var categoryInfo: List<CategoryInfoItem>? = null,
    var toppics: Toppics? = null
)
