package com.appmea.nestedrv;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class VPAdapter extends FragmentStateAdapter {

    private static final int ITEM_COUNT = 2;

    public static final int POSITION_ALL = 0;
    public static final int POSITION_MY  = 1;

    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public VPAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public VPAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case POSITION_ALL:
                return SimpleFragment.newInstance("test 1");
            case POSITION_MY:
                return SimpleFragment.newInstance("test 2");
            default:
                throw new RuntimeException("Position outside range");
        }
    }

    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }
    // </editor-fold>
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
