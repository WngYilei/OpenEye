package com.xl.openeye.ui

import com.xl.openeye.R

sealed class NavigationItem(
    var route: String,
    var icon: Int,
    var title: String,

    ) {
    object Home : NavigationItem("home", R.drawable.ic_home, "首页")
    object Discovery : NavigationItem("discovery", R.drawable.ic_movie, "发现")
    object Hot : NavigationItem("hot", R.drawable.ic_book, "热门")
    object Mine : NavigationItem("mine", R.drawable.ic_profile, "我的")
}