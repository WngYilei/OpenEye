package com.xl.openeye.ui.discover

import androidx.lifecycle.viewModelScope
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
class DiscoverViewModel @Inject constructor(var repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState(isFirst = true)) {

    private val pendingActions = Channel<ViewEvent>(Channel.BUFFERED)

    init {
        viewModelScope.launch {
            pendingActions.consumeAsFlow().collect { action ->
                when (action) {
                    ViewEvent.RefreshFollow -> getFollow()
                    ViewEvent.RefreshType -> getType()
                    ViewEvent.RefreshToppoc -> getToppoc(0)
                    ViewEvent.RefreshNewInfo -> getNewInfo(0)
                    ViewEvent.RefreshRecommend -> getRecommend("1640770607000")

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


    fun getFollow() {
        setState {
            copy(loading = true, refresh = true, homeInfo = null)
        }
        viewModelScope.launch {
            val data = repository.getFollow("0")
            setState {
                copy(loading = false, followInfo = data, homeInfo = null)
            }
        }
    }

    fun getType() {
        setState {
            copy(loading = true, refresh = true, categoryInfo = null)
        }

        viewModelScope.launch {
            val data = repository.getType()
            setState {
                copy(loading = false, refresh = false, categoryInfo = data)
            }
        }
    }


    fun getToppoc(index: Int) {
        setState {
            copy(loading = true, refresh = true, toppics = null)
        }

        viewModelScope.launch {
            val data = repository.getToppic(index)
            setState {
                copy(loading = false, refresh = false, toppics = data)
            }
        }
    }

    fun getNewInfo(index: Int) {
        setState {
            copy(loading = true, refresh = true, newsInfo = null)
        }

        viewModelScope.launch {
            val data = repository.getNewInfo(index)
            setState {
                copy(loading = false, refresh = false, newsInfo = data)
            }
        }
    }

    fun getRecommend(index: String) {
        setState {
            copy(loading = true, refresh = true, recommendInfo = null)
        }

        viewModelScope.launch {
            val data = repository.getRecommend(index)
            setState {
                copy(loading = false, refresh = false, recommendInfo = data)
            }
        }
    }
}