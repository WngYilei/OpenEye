package com.xl.openeye.ui.me

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.xl.openeye.R
import com.xl.openeye.databinding.MeFragmentBinding
import com.xl.xl_base.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeFragment : BaseFragment<MeFragmentBinding>(MeFragmentBinding::inflate) {

    companion object {
        fun newInstance() = MeFragment()
    }

    private val viewModel: MeViewModel by viewModels()


    override fun onFragmentCreate(savedInstanceState: Bundle?) {

    }

}