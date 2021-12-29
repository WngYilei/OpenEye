package com.xl.openeye.ui.home


import android.util.Log
import androidx.lifecycle.viewModelScope
import com.xl.openeye.repository.DataRepository
import com.xl.openeye.state.ViewState
import com.xl.xl_base.base.ReduxViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: DataRepository) :
    ReduxViewModel<ViewState>(ViewState(isFirst = true)) {
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

    fun getNextHome(date: String, num: String) {
        Log.e("TAG", "date: $date")
        Log.e("TAG", "num: $num")
        setState {
            copy(loading = true, homeInfo = null)
        }
        viewModelScope.launch {
            setState { copy(loading = true) }
            val data = repository.getNextHome(date, num)
            setState {
                copy(loading = true, refresh = false, homeInfo = data)
            }
        }
    }
}
