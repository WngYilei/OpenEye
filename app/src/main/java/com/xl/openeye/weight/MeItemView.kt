package com.xl.openeye.weight

import android.content.Context
import android.widget.RelativeLayout
import android.view.LayoutInflater
import android.util.AttributeSet
import com.xl.openeye.R
import com.xl.openeye.databinding.ViewMeItemBinding

class MeItemView : RelativeLayout {
    var viewMeItemBinding: ViewMeItemBinding? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet) {
        viewMeItemBinding = ViewMeItemBinding.inflate(LayoutInflater.from(getContext()), this, false)
        addView(viewMeItemBinding!!.root)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.meitem)
        val icon = typedArray.getResourceId(R.styleable.meitem_icon, 0)
        val text = typedArray.getString(R.styleable.meitem_text)
        typedArray.recycle()
        viewMeItemBinding!!.meIcon.setImageDrawable(resources.getDrawable(icon, null))
        viewMeItemBinding!!.meText.text = text
    }
}