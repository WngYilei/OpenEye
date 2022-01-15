package com.xl.openeye.state

sealed class ViewEvent {
    object Refresh : ViewEvent()
    object RefreshFollow : ViewEvent()
    object RefreshType : ViewEvent()
    object RefreshToppoc : ViewEvent()
    object RefreshNewInfo : ViewEvent()
    object RefreshRecommend : ViewEvent()

    object RefreshWeekRanking :ViewEvent()
    object RefreshMonthRanking :ViewEvent()
    object RefreshTotalRanking :ViewEvent()
}
