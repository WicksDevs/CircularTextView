package com.example.circulartextview.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;


public class CircularTextView extends TextView {

    private static final String TAG = CircularTextView.class.getName();
    private static final float mFactor = 0.416f;
    private Paint mPaint = new Paint();
    private int mCircleBackground;
    private int mTextColor;

    public CircularTextView(Context context) {
        super(context);
        mCircleBackground = getResources().getColor(android.R.color.white);
        mTextColor =  getResources().getColor(android.R.color.black);
    }

    public CircularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCircleBackground = getResources().getColor(android.R.color.white);
        mTextColor = getResources().getColor(android.R.color.black);;
    }

    public CircularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCircleBackground = getResources().getColor(android.R.color.white);
        mTextColor =  getResources().getColor(android.R.color.black);;
    }


    private TextView getTextForCircle() {
        TextView textView = new TextView(getContext());
        textView.setText("A");
        return textView;
    }

    private void setupDraw() {
        mPaint.setColor(mCircleBackground);
        mPaint.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        setupDraw();
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,mPaint);
        super.onDraw(canvas);
        setTextColor(mTextColor);
        setText(getText().subSequence(0,1).toString().toUpperCase());
        setTextSize(pixelsToSp(getWidth() * mFactor));
        setGravity(Gravity.CENTER);
    }

    private float pixelsToSp(float px) {
        float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
        return px/scaledDensity;
    }

    @Override
    public void setBackgroundColor(int color) {
        mCircleBackground = color;
    }

    public void setmTextColor(int color) {
        mTextColor = color;
    }
}
