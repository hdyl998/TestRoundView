package com.hd.mylib.roundrect;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.hd.mylib.R;


/**
 * 圆角矩形背景的相对布局
 * Created by liugd on 2017/1/3.
 */

public class ShapeBgRelativeLayout extends RelativeLayout {

    private float mRadius;
    private int mColorBg;
    private int mBorderColor;
    private float mBorderWidth;
    private int mColorBgEnd;
    private int mBorderColorEnd;

    public ShapeBgRelativeLayout(Context context) {
        super(context);
    }

    public ShapeBgRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeBgRelativeLayout);
        mRadius = mTypedArray.getDimension(R.styleable.ShapeBgRelativeLayout_appRadius, RoundRectConstants.cornerRadius);
        mColorBg = mTypedArray.getColor(R.styleable.ShapeBgRelativeLayout_appBgColor, Color.BLACK);
        mBorderColor = mTypedArray.getColor(R.styleable.ShapeBgRelativeLayout_appBorderColor, Color.TRANSPARENT);
        mBorderWidth = mTypedArray.getDimension(R.styleable.ShapeBgRelativeLayout_appBorderWidth, RoundRectConstants.shapeLineWidth);

        mColorBgEnd = mTypedArray.getColor(R.styleable.ShapeBgRelativeLayout_appBgColorEnd, Color.TRANSPARENT);
        mBorderColorEnd = mTypedArray.getColor(R.styleable.ShapeBgRelativeLayout_appBorderColorEnd, Color.TRANSPARENT);
        mTypedArray.recycle();
    }

    public void setRadius(float mRadius) {
        this.mRadius = mRadius;
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        setBackgroundDrawable(getBgDrawable());
    }


    private Drawable getBgDrawable() {
        if (mBorderColor == Color.TRANSPARENT) {
            return RoundRectTool.getRoundRectBgDrawable(mRadius, mColorBg, mColorBgEnd, getWidth());
        } else {
            Drawable[] array = {
                    RoundRectTool.getRoundRectBgDrawable(mRadius, mColorBg, mColorBgEnd, getWidth()),
                    RoundRectTool.getRoundRectBorderDrawable(mRadius, mBorderColor, mBorderWidth, mBorderColorEnd, getWidth())};
            LayerDrawable ld = new LayerDrawable(array);
            return ld;
        }
    }
}
