package com.xl.openeye.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xl.openeye.R;
import com.xl.openeye.databinding.ViewMeItemBinding;

public class MeItemView extends RelativeLayout {
    ViewMeItemBinding viewMeItemBinding;

    public MeItemView(Context context) {
        super(context);
    }

    public MeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public MeItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public MeItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        viewMeItemBinding = ViewMeItemBinding.inflate(LayoutInflater.from(getContext()), this, false);
        addView(viewMeItemBinding.getRoot());
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.meitem);
        int icon = typedArray.getResourceId(R.styleable.meitem_icon, 0);
        String text = typedArray.getString(R.styleable.meitem_text);
        typedArray.recycle();
        viewMeItemBinding.meIcon.setImageDrawable(getResources().getDrawable(icon, null));
        viewMeItemBinding.meText.setText(text);
    }

}
