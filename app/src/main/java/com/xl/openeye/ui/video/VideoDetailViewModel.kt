package com.xl.openeye.ui.video

import androidx.lifecycle.viewModelScope
import com.xl.openeye.repository.DataRepository
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoDetailViewModel @Inject constructor(var repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState(isFirst = true)) {

    fun getVideoRecommend(id: String) {
        setState {
            copy(loading = true, refresh = true, videoRecommendInfo = null)
        }
        viewModelScope.launch {
            val data = repository.getVideoRecommend(id)
            setState {
                copy(loading = false, refresh = false, videoRecommendInfo = data)
            }
        }
    }

}