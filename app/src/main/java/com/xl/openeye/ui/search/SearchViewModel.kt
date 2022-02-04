package com.xl.openeye.ui.search

import androidx.lifecycle.viewModelScope
import com.xl.openeye.repository.DataRepository
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(var repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState()) {

    fun getSearch(query: String) {
        setState {
            copy(loading = true, refresh = true, searchInfo = null)
        }
        viewModelScope.launch {
            setState { copy(loading = true) }
            val data = repository.getSearch(query)
            setState {
                copy(loading = true, refresh = true, searchInfo = data)
            }
        }
    }

}