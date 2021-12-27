package com.xl.openeye.ui.hot

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xl.openeye.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotFragment : Fragment() {

    companion object {
        fun newInstance() = HotFragment()
    }

    private lateinit var viewModel: HotViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hot_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HotViewModel::class.java)
        // TODO: Use the ViewModel
    }

}