package com.appmea.nestedrv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import timber.log.Timber;

public class CustomCL extends ConstraintLayout {
    // ====================================================================================================================================================================================
    // <editor-fold desc="Constants">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Properties">

    private float oldX;
    private float oldY;
    private float newX;
    private float newY;
    int direction;
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Constructor">

    public CustomCL(@NonNull Context context) {
        super(context);
    }

    public CustomCL(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCL(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Android Lifecycle">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Initialisation">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Interfaces">

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
////        getParent().requestDisallowInterceptTouchEvent(true);
//        return true;
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                oldX = event.getX();
                oldY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                newX = event.getX();
                newY = event.getY();

                int deltaX = (int) (oldX - newX);
                int deltaY = (int) (oldY - newY);

                Timber.e("onTouchEvent: %d, %d", deltaX, deltaY);
                if (Math.abs(deltaY) > Math.abs(deltaX)) {
                    //Motion in Y direction.
                    direction = deltaY <= 0 ? 0 : 1;
                } else {
                    // Motion in X direction.
                }
                break;
        }
        return super.onTouchEvent(event);
    }
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Methods">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Getter & Setter">
    // </editor-fold>
}
