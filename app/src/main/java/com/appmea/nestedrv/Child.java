package com.appmea.nestedrv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import timber.log.Timber;

public class Child extends RecyclerView {
    private float   oldX;
    private float   oldY;
    private float   newX;
    private float   newY;
    private boolean isIntercepting;

    int direction;
    public LinearLayoutManager layoutManager;

    public Child(@NonNull Context context) {
        super(context);
    }

    public Child(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Child(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setLayoutManager(@Nullable LayoutManager layout) {
        super.setLayoutManager(layout);
        this.layoutManager = (LinearLayoutManager) layout;
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        Timber.e("dispatchNestedScroll: ");
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        Timber.e("dispatchNestedScroll: ");
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        Timber.e("dispatchNestedPreScroll: ");
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        Timber.e("dispatchNestedPreScroll: ");
//        if (layoutManager.findFirstCompletelyVisibleItemPosition() == 0 && dy < 0) {
//            Timber.e("dispatchNestedPreScroll: ENABLING");
//            getParent().requestDisallowInterceptTouchEvent(false);
//        }
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
    }


    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        Timber.e("dispatchNestedFling: ");
        return super.dispatchNestedFling(velocityX, velocityY, consumed);
    }


    @Override
    public boolean startNestedScroll(int axes) {
        Timber.e("startNestedScroll: ");
        return super.startNestedScroll(axes);
    }

    @Override
    public boolean startNestedScroll(int axes, int type) {
        Timber.e("startNestedScroll: ");
        return super.startNestedScroll(axes, type);
    }

    @Override
    public void stopNestedScroll() {
        Timber.e("stopNestedScroll: ");
        super.stopNestedScroll();
    }

    @Override
    public void stopNestedScroll(int type) {
        Timber.e("stopNestedScroll: ");
        super.stopNestedScroll(type);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return super.onStartNestedScroll(child, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        super.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        super.onStopNestedScroll(child);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Timber.e("onNestedScroll: ");
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        Timber.e("onNestedPreScroll: ");
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Timber.e("onTouchEvent: DOWN");
//                oldX = event.getX();
//                oldY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                Timber.e("onTouchEvent: MOVE");
                Timber.e("onTouchEvent: DISABLING");
                getParent().requestDisallowInterceptTouchEvent(true);
//                newX = event.getX();
//                newY = event.getY();
//
//                int deltaX = (int) (oldX - newX);
//                int deltaY = (int) (oldY - newY);
//
////                Timber.e("onTouchEvent: %d, %d", deltaX, deltaY);
//                if (!isIntercepting) {
//                    isIntercepting = true;
//                    if (Math.abs(deltaY) > Math.abs(deltaX)) {
//                        //Motion in Y direction.
//                        Timber.e("onInterceptTouchEvent: DISABLE");
//                        getParent().requestDisallowInterceptTouchEvent(true);
//                        direction = deltaY <= 0 ? 0 : 1;
//                        if (direction == 0) {
//                            // Scroll top
//                            if (((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) {
//                                Timber.e("onTouchEvent: ENABLE");
//                                getParent().requestDisallowInterceptTouchEvent(false);
//                            }
//                        } else {
//                            // Scroll bottom
////                            if (((LinearLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPosition() != getAdapter().getItemCount() - 1) {
////                                Timber.e("onTouchEvent: ENABLE");
////                                getParent().requestDisallowInterceptTouchEvent(false);
////                            }
//                        }
//
//                    } else {
//                        // Motion in X direction.
//                        Timber.e("onTouchEvent: ENABLE");
//                        getParent().requestDisallowInterceptTouchEvent(false);
//                    }
//                }
                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_POINTER_UP:
//            case MotionEvent.ACTION_CANCEL:
//                isIntercepting = false;
//                getParent().requestDisallowInterceptTouchEvent(false);
//                break;
//
        }
        boolean ret = super.onTouchEvent(event);
        Timber.e("onTouchEvent: %s", ret);
        return ret;
    }

    //
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
//        Timber.e("onInterceptTouchEvent: DISABLE");
//        getParent().requestDisallowInterceptTouchEvent(true);
        boolean ret = super.onInterceptTouchEvent(event);
        Timber.e("onInterceptTouchEvent: %s", ret);
        return ret;
    }

    // ====================================================================================================================================================================================
    // <editor-fold desc="Constants">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Properties">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Constructor">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Android Lifecycle">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Initialisation">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Interfaces">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Methods">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Getter & Setter">
    // </editor-fold>
}
