package com.xl.openeye.ui

import android.graphics.Color
import android.os.Bundle
import android.view.Window
import com.xl.openeye.R
import com.xl.openeye.databinding.ActivityMainBinding
import com.xl.openeye.ui.discover.DiscoverFragment
import com.xl.openeye.ui.home.HomeFragment
import com.xl.openeye.ui.hot.HotFragment
import com.xl.openeye.ui.me.MeFragment
import com.xl.xl_base.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import android.view.WindowManager


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val window: Window = window
        window.clearFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )
        window.statusBarColor = Color.TRANSPARENT

        viewBinding.bottomBarActivityMain
            .setContainer(R.id.fl_content_activity_main)
            .setTitleSize(12)
            .setIconHeight(22)
            .setIconWidth(22)
            .setTitleBeforeAndAfterColor(
                "#666666", "#000000"
            )
            .addItem(
                HomeFragment::class.java,
                getString(R.string.menu_home),
                R.mipmap.ic_home_normal,
                R.mipmap.ic_home_selected
            )
            .addItem(
                DiscoverFragment::class.java,
                getString(R.string.menu_duscover),
                R.mipmap.ic_discovery_normal,
                R.mipmap.ic_discovery_selected
            )
            .addItem(
                HotFragment::class.java,
                getString(R.string.menu_hot),
                R.mipmap.ic_hot_normal,
                R.mipmap.ic_hot_selected
            )
            .addItem(
                MeFragment::class.java,
                getString(R.string.menu_me),
                R.mipmap.ic_home_normal,
                R.mipmap.ic_home_selected
            )
            .build()
        viewBinding.bottomBarActivityMain.setClickListen {

        }
    }
}