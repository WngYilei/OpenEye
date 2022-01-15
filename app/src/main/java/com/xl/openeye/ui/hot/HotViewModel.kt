package com.xl.openeye.ui.hot

import androidx.lifecycle.viewModelScope
import com.xl.openeye.annotation.RankingType
import com.xl.openeye.repository.DataRepository
import com.xl.openeye.state.ViewEvent
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotViewModel @Inject constructor(private val repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState()) {

    private val pendingActions = Channel<ViewEvent>(Channel.BUFFERED)

    init {
        viewModelScope.launch {
            pendingActions.consumeAsFlow().collect { action ->
                when (action) {
                    ViewEvent.RefreshWeekRanking -> getRanking(RankingType.WEEK)
                    ViewEvent.RefreshMonthRanking -> getRanking(RankingType.MONTH)
                    ViewEvent.RefreshTotalRanking -> getRanking(RankingType.TOTAL)

                }
            }
        }
    }

    fun submitAction(action: ViewEvent) {
        viewModelScope.launch {
            if (!pendingActions.isClosedForReceive) {
                pendingActions.send(action)
            }
        }
    }

    fun getRanking(@RankingType type: String) {
        setState {
            copy(loading = true, refresh = true, toppics = null)
        }

        viewModelScope.launch {
            val data = repository.getRanking(type)
            setState {
                copy(loading = false, refresh = false, rankingInfo = data)
            }
        }
    }
}