package com.xl.openeye.ui.search

import android.os.Bundle
import androidx.activity.viewModels
import com.xl.openeye.databinding.ActivitySearchBinding
import com.xl.xl_base.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate) {

    val viewModel: SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}