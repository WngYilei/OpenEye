package com.xl.openeye.state

import com.xl.openeye.dataclass.FollowInfo
import com.xl.openeye.dataclass.HomeInfo

data class ViewState(
    var isFirst: Boolean = false,
    val loading: Boolean = false,
    val refresh: Boolean = false,
    var homeInfo: HomeInfo? = null,
    var followInfo: FollowInfo? = null
)
