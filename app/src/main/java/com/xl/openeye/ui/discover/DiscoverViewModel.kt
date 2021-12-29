package com.xl.openeye.ui.discover

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.xl.openeye.repository.DataRepository
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(var repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState(isFirst = true)) {

    fun getFollow(num: String) {
        setState {
            copy(loading = true, refresh = true, homeInfo = null)
        }
        viewModelScope.launch {
            val data = repository.getFollow(num)
            setState {
                copy(loading = true, refresh = true, followInfo = data,homeInfo = null)
            }
        }
    }
}