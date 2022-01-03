package com.xl.openeye.ui.hot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xl.openeye.annotation.RankingType
import com.xl.openeye.repository.DataRepository
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotViewModel @Inject constructor(private val repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState()) {


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