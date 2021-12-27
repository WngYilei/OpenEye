package com.xl.openeye.ui.discover

import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor() : ReduxViewModel<ViewState>(ViewState()) {

}