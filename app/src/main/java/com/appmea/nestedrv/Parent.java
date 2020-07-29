package com.appmea.nestedrv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent3;
import androidx.recyclerview.widget.RecyclerView;

import timber.log.Timber;

public class Parent extends RecyclerView implements NestedScrollingParent3 {
    private float oldX;
    private float oldY;
    private float newX;
    private float newY;

    int direction;
    private boolean isIntercepting;

    public Parent(@NonNull Context context) {
        super(context);
    }

    public Parent(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Parent(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        Timber.e("dispatchNestedScroll: ");
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }


    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        Timber.e("dispatchNestedPreScroll: ");
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
    public boolean onInterceptTouchEvent(MotionEvent e) {

//        Timber.e("onInterceptTouchEvent: action %s", e. ());
//        Timber.e("onInterceptTouchEvent: %s", ((LinearLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPosition());
//        Timber.e("onInterceptTouchEvent: %s", ((LinearLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPosition() != getAdapter().getItemCount() - 1);
//        return ((LinearLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPosition() != getAdapter().getItemCount() - 1;
        return super.onInterceptTouchEvent(e);
//        return false;
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
                break;
        }

//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                oldX = event.getX();
//                oldY = event.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
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
////                            if (((LinearLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPosition() != getChildCount() - 1) {
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
//                break;
//        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
        Timber.e("onNestedScroll: ");
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        Timber.e("onStartNestedScroll: ");
        return false;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        Timber.e("onNestedScrollAccepted: ");
    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {
        Timber.e("onStopNestedScroll: ");
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Timber.e("onNestedScroll: ");
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        Timber.e("onNestedPreScroll: ");
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
