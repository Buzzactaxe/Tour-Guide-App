package com.example.android.tourappbari;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

public class ExpandAnimation extends Animation {

    private View mAnimatedView;
    private LinearLayout.LayoutParams mViewLayoutParams;
    private int mMarginStart, mMarginEnd;
    private boolean mIsVisibleAfter = false;
    private boolean mWasEndedAlready = false;

    /**
     * Initialize the animation
     *
     * @param view     The layout we want to animate
     * @param duration The duration of the animation, in ms
     */
    public ExpandAnimation(View view, int duration) {

        //Set duration
        setDuration(duration);

        //Animated view
        mAnimatedView = view;

        //Layout params
        mViewLayoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();

        // decide to show or hide the view
        mIsVisibleAfter = (view.getVisibility() == View.VISIBLE);

        //Margin start & end
        mMarginStart = mViewLayoutParams.bottomMargin;
        mMarginEnd = (mMarginStart == 0 ? (0 - view.getHeight()) : 0);

        view.setVisibility(View.VISIBLE);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        if (interpolatedTime < 1.0f) {

            // Calculating the new bottom margin, and setting it
            mViewLayoutParams.bottomMargin = mMarginStart
                    + (int) ((mMarginEnd - mMarginStart) * interpolatedTime);

            // Invalidating the layout, making us seeing the changes we made
            mAnimatedView.requestLayout();
        }
        // Making sure we didn't run the ending before
        else if (!mWasEndedAlready) {
            mViewLayoutParams.bottomMargin = mMarginEnd;
            mAnimatedView.requestLayout();

            //Set animated view to GONE
            if (mIsVisibleAfter) {
                mAnimatedView.setVisibility(View.GONE);
            }
            mWasEndedAlready = true;
        }
    }


}