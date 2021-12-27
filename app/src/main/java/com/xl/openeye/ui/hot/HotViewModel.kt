package com.xl.openeye.ui.hot

import androidx.lifecycle.ViewModel
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotViewModel @Inject constructor() :  ReduxViewModel<ViewState>(ViewState())  {

}