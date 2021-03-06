package com.xl.openeye.ui.home

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
class HomeViewModel @Inject constructor(private val repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState()) {

    private val pendingActions = Channel<ViewEvent>(Channel.BUFFERED)

    init {
        viewModelScope.launch {
            pendingActions.consumeAsFlow().collect { action ->
                when (action) {
                    ViewEvent.Refresh -> getHome(0)
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



    fun getHome(index: Int) {
        setState {
            copy(loading = true, refresh = true, homeInfo = null)
        }
        viewModelScope.launch {
            setState { copy(loading = true) }
            val data = repository.getHome(index.toString())
            setState {
                copy(loading = true, refresh = true, homeInfo = data)
            }
        }
    }

    fun getNextHome(date: String) {
        setState {
            copy(loading = true, homeInfo = null)
        }
        viewModelScope.launch {
            setState { copy(loading = true) }
            val data = repository.getNextHome(date)
            setState {
                copy(loading = true, refresh = false, homeInfo = data)
            }
        }
    }
}
