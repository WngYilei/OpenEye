package com.xl.openeye.ui.discover.special

import androidx.lifecycle.viewModelScope
import com.xl.openeye.repository.DataRepository
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpecialDetailViewModel @Inject constructor(var repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState(isFirst = true)) {

    fun getSpecialDetail(id: String) {
        setState {
            copy(loading = true, refresh = true, specialDetailInfo = null)
        }
        viewModelScope.launch {
            val data = repository.getSpecialDetail(id)
            setState {
                copy(loading = false, refresh = false, specialDetailInfo = data)
            }
        }
    }
}