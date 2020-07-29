package com.appmea.nestedrv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent3;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import timber.log.Timber;

public class NestedRecycler extends RecyclerView implements NestedScrollingParent3 {

    private View    nestedScrollTarget                  = null;
    private boolean nestedScrollTargetIsBeingDragged    = false;
    private boolean nestedScrollTargetWasUnableToScroll = false;
    private boolean skipsTouchInterception              = false;

    private LinearLayoutManager layoutManager;

    public NestedRecycler(Context context) {
        this(context, null);
    }

    public NestedRecycler(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setLayoutManager(@Nullable LayoutManager layout) {
        super.setLayoutManager(layout);
        layoutManager = (LinearLayoutManager) layout;
    }

//    // Called after child dispatchNestedPreScroll(), to give parent opportunity to react before child
//    @Override
//    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
//        Timber.e("onNestedPreScroll: %d", dy);
//        if (dy < 0) {
//            // Scroll top
//
//        } else {
//            // Scroll bottom
//            if (layoutManager.findLastCompletelyVisibleItemPosition() != getAdapter().getItemCount() - 1) {
//                scrollBy(0, dy);
//                consumed[1] = dy;
//            }
//        }
//
//        super.onNestedPreScroll(target, dx, dy, consumed);
//    }


//    // Parent gets the opportunity to consume any remaining scroll pixels that have still not been consumed, after child.dispatchNestedScroll().
//    @Override
//    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
//        Timber.e("onNestedScroll: ");
//        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
//
////        if (target == nestedScrollTarget && !nestedScrollTargetIsBeingDragged) {
////            if (dyConsumed != 0) {
////                // The descendent was actually scrolled, so we won't bother it any longer.
////                // It will receive all future events until it finished scrolling.
////                nestedScrollTargetIsBeingDragged = true;
////                nestedScrollTargetWasUnableToScroll = false;
////            } else if (dyConsumed == 0 && dyUnconsumed != 0) {
////                // The descendent tried scrolling in response to touch movements but was not able to do so.
////                // We remember that in order to allow RecyclerView to take over scrolling.
////                nestedScrollTargetWasUnableToScroll = true;
////                if (target.getParent() != null) {
////                    target.getParent().requestDisallowInterceptTouchEvent(false);
////                }
////            }
////        }
//    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Timber.e("dispatchTouchEvent: ");
//        boolean temporarilySkipsInterception = nestedScrollTarget != null;
//        if (temporarilySkipsInterception) {
//            // If a descendent view is scrolling we set a flag to temporarily skip our onInterceptTouchEvent implementation
//            skipsTouchInterception = true;
//        }
//
//        // First dispatch, potentially skipping our onInterceptTouchEvent
//        boolean handled = super.dispatchTouchEvent(ev);
//
//        if (temporarilySkipsInterception) {
//            skipsTouchInterception = false;
//
//            // If the first dispatch yielded no result or we noticed that the descendent view is unable to scroll in the
//            // direction the user is scrolling, we dispatch once more but without skipping our onInterceptTouchEvent.
//            // Note that RecyclerView automatically cancels active touches of all its descendents once it starts scrolling
//            // so we don't have to do that.
//            if (!handled || nestedScrollTargetWasUnableToScroll) {
//                handled = super.dispatchTouchEvent(ev);
//            }
//        }
//
//        return handled;
//    }

//    // Skips RecyclerView's onInterceptTouchEvent if requested
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent e) {
//        Timber.e("onInterceptTouchEvent: ");
//        return super.onInterceptTouchEvent(e);
//    }


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
        boolean ret = super.onTouchEvent(event);
        Timber.e("onTouchEvent: %s", ret);
        return ret;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
//        Timber.e("onInterceptTouchEvent: DISABLE");
//        getParent().requestDisallowInterceptTouchEvent(true);
        boolean ret = super.onInterceptTouchEvent(event);
        Timber.e("onInterceptTouchEvent: %s", ret);
        return ret;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        Timber.e("onNestedScrollAccepted: ");
        if (axes != 0 && View.SCROLL_AXIS_VERTICAL != 0) {
            // A descendent started scrolling, so we'll observe it.
            nestedScrollTarget = target;
            nestedScrollTargetIsBeingDragged = false;
            nestedScrollTargetWasUnableToScroll = false;
        }

        super.onNestedScrollAccepted(child, target, axes);
    }

//    @Override
//    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
////        boolean secondPart = Build.VERSION.SDK_INT < 21 || View.SCROLL_AXIS_VERTICAL != 0;
////        return (nestedScrollAxes != 0 && secondPart);
////        Timber.e("onStartNestedScroll: ");
//        return true;
//    }

//    @Override
//    public void onStopNestedScroll(View child) {
//        nestedScrollTarget = null;
//        nestedScrollTargetIsBeingDragged = false;
//        nestedScrollTargetWasUnableToScroll = false;
//    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
        Timber.e("onNestedScroll: 3");
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        Timber.e("onStartNestedScroll: 3");
        return true;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        Timber.e("onNestedScrollAccepted: 3");
        super.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {
        Timber.e("onStopNestedScroll: 3");

    }


    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        Timber.e("onNestedPreScroll: %d", dy);
        if (dy < 0) {
            // Scroll top
            if (target instanceof Child) {
                if (((Child) target).layoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    scrollBy(0, dy);
                    consumed[1] = dy;
                }
            }

        } else {
            // Scroll bottom
            if (layoutManager.findLastCompletelyVisibleItemPosition() != getAdapter().getItemCount() - 1) {
                scrollBy(0, dy);
                consumed[1] = dy;
            }
        }

        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Timber.e("onNestedScroll: 3");

    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        Timber.e("dispatchNestedPreFling: ");
        return super.dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Timber.e("onNestedPreFling: ");


        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Timber.e("onNestedFling: ");
        if (velocityY < 0) {
            // Scroll top
            if (target instanceof Child) {
                if (((Child) target).layoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    fling(0, (int) velocityY);
                    return true;
                }
            }

        } else {
            // Scroll bottom
            if (layoutManager.findLastCompletelyVisibleItemPosition() != getAdapter().getItemCount() - 1) {
                fling(0, (int) velocityY);
                return true;
            }
        }
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }
}