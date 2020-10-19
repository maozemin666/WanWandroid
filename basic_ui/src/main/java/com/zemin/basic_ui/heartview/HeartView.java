package com.zemin.basic_ui.heartview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Date 2020/10/9 20:38
 * @Created by zemin
 */
public class HeartView extends View {
    private Paint paint;
    private float heartWidth;
    private float heartHeight;
    private float canvasTransX;
    private float canvasTransY;
    private Path heartPath;

    public HeartView(Context context) {
        this(context, null);
    }

    public HeartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);

        heartPath = new Path();
        heartPath.moveTo(0F, -115F);
        heartPath.cubicTo(-50F, -165F, -161F, -141F, -161F, -44F);
        heartPath.cubicTo(-161F, 59F, -20F, 141F, 0F, 141F);
        heartPath.cubicTo(20F, 141F, 161F, 59F, 161F, -44F);
        heartPath.cubicTo(161F, -141F, 50F, -165F, 0F, -115F);
        heartPath.close();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = getSize(widthMeasureSpec, getSuggestedMinimumWidth());
        int measureHeight = getSize(heightMeasureSpec, getSuggestedMinimumHeight());
        setMeasuredDimension(measureWidth, measureHeight);
    }

    @Override
    public int getSuggestedMinimumWidth() {
        return (int) (getSuggestedMinimumSize() + getPaddingStart() + getPaddingEnd());
    }

    @Override
    public int getSuggestedMinimumHeight() {
        return 0;
    }

    private float getSuggestedMinimumSize() {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24f
                , getContext().getResources().getDisplayMetrics());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        refresh();
    }

    private void refresh() {
        refresh(false);
    }

    private void refresh(boolean invalidate) {
        heartWidth = getMeasuredWidth() - getPaddingStart() - getPaddingEnd();
        heartHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        canvasTransX = (heartWidth / 2) + getPaddingStart();
        canvasTransY = (heartHeight / 2) + getPaddingTop();
    }

    private int getSize(int measureSpec, int suggestedSize) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result;
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                result = suggestedSize;
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            default:
                result = suggestedSize;
                break;
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }
}
