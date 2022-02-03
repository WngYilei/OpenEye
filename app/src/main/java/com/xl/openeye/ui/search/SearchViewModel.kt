package com.xl.openeye.ui.search

import com.xl.openeye.repository.DataRepository
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(repository: DataRepository) : ReduxViewModel<ViewState>(ViewState()) {


}