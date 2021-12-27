package com.xl.openeye.ui.discover

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.xl.openeye.R
import com.xl.openeye.databinding.DiscoverFragmentBinding
import com.xl.xl_base.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : BaseFragment<DiscoverFragmentBinding>(DiscoverFragmentBinding::inflate) {

    companion object {
        fun newInstance() = DiscoverFragment()
    }

    private val viewModel: DiscoverViewModel by viewModels()


    override fun onFragmentCreate(savedInstanceState: Bundle?) {

    }

}