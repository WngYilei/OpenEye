package com.xl.openeye.ui.discover.type

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xl.openeye.R
import com.xl.openeye.databinding.FragmentTypeBinding
import com.xl.openeye.itemcell.CategoryItem
import com.xl.openeye.itemcell.FollowItem
import com.xl.openeye.ui.discover.DiscoverViewModel
import com.xl.xl_base.adapter.image.ImageLoader
import com.xl.xl_base.adapter.item.ItemCell
import com.xl.xl_base.adapter.recycler.AdapterConfig
import com.xl.xl_base.adapter.recycler.GridDividerItemDecoration
import com.xl.xl_base.adapter.recycler.RecyclerAdapter
import com.xl.xl_base.adapter.recycler.createAdapter
import com.xl.xl_base.base.BaseFragment
import com.xl.xl_base.tool.ktx.collectHandlerFlow
import com.xl.xl_base.tool.ktx.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TypeFragment : BaseFragment<FragmentTypeBinding>(FragmentTypeBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() = TypeFragment()
    }

    lateinit var recyclerAdapter: RecyclerAdapter
    val viewModel: DiscoverViewModel by viewModels()
    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        recyclerAdapter = createAdapter {
            imageLoader = ImageLoader(this@TypeFragment)
        }
        viewModel.getType()
        viewBinding.recycle.apply {
            adapter = AdapterConfig.createNo(recyclerAdapter)
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(
                GridDividerItemDecoration(
                    0,
                    0.5.dp, Color.parseColor("#EEEEEE")
                )
            )
        }

        viewModel.state.collectHandlerFlow(this) { state ->
            state.categoryInfo?.let { it ->
                val items = mutableListOf<ItemCell>()
                it.forEach {
                    items.add(CategoryItem(it))
                }
                items.size.let { it1 ->
                    recyclerAdapter.submitList(it1, items)
                }
            }
        }
    }
}