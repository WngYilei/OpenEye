package com.xl.openeye.state

import com.xl.openeye.dataclass.HomeInfo

data class ViewState(
    val loading: Boolean = false,
    val refresh: Boolean = false,
    val homeInfo: HomeInfo? = null,
    val data:String = ""
)
