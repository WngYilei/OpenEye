package com.xl.openeye.weight

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.xl.openeye.R
import com.xl.openeye.databinding.LayoutTitleBinding

class AppBar(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    var layoutTitleBinding: LayoutTitleBinding

    init {
        val view = View.inflate(context, R.layout.layout_title, null)
        layoutTitleBinding = LayoutTitleBinding.bind(view)
        addView(view)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    fun setTitle(title: String) {
        Log.e("TAG", "setTitle: " + title)
        layoutTitleBinding.title.text = title
    }

    fun setSearchListener(search: () -> Unit) {
        layoutTitleBinding.imgSearch.setOnClickListener {
            search.invoke()
        }
    }

}