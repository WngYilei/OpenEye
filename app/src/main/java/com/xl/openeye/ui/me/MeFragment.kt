package com.xl.openeye.ui.me

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.xl.openeye.R
import com.xl.openeye.databinding.MeFragmentBinding
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.util.StatusBarUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeFragment : BaseFragment<MeFragmentBinding>(MeFragmentBinding::inflate) {

    companion object {
        fun newInstance() = MeFragment()
    }
    override fun onFragmentCreate(savedInstanceState: Bundle?) {

        Glide.with(this).load(R.mipmap.logo).apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(viewBinding.imgMeHeard)
    }


    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        StatusBarUtils.setStatusBarColor(
            activity as Activity,
            if (hidden) R.color.white else R.color.me_title
        )
    }
}