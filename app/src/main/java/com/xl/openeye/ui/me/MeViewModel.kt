package com.xl.openeye.ui.me

import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MeViewModel @Inject constructor() : ReduxViewModel<ViewState>(ViewState()) {

}