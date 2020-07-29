package com.appmea.nestedrv;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;


public class ItemCouponVP extends AbstractFlexibleItem<ItemCouponVP.VHCouponVP> {
    // ====================================================================================================================================================================================
    // <editor-fold desc="Constants">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Properties">

    private List<String> item;
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Constructor">

    public ItemCouponVP(List<String> item) {
        this.item = item;
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

    @Override
    public boolean equals(Object o) {
        return o == this;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.item_coupon_vp;
    }

    @Override
    public VHCouponVP createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new VHCouponVP(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, VHCouponVP holder, int position, List<Object> payloads) {
        holder.update(item, payloads);
    }
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Methods">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Getter & Setter">
    // </editor-fold>


    /**
     * ViewHolder class
     */
    static class VHCouponVP extends FlexibleViewHolder {
        // ====================================================================================================================================================================================
        // <editor-fold desc="Constants">
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Properties">

        private List<String> item;

        private FlexibleAdapter<ItemSimpleItem> adapter;
        private LinearLayoutManager             layoutManager;

        @BindView(R.id.vp_items) ViewPager2 vpItems;
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Constructor">

        public VHCouponVP(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            ButterKnife.bind(this, view);

            initListener();
            initVP();
        }
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Android Lifecycle">
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Initialisation">

        private void initListener() {
        }


        private void initVP() {
            VPAdapter adapter = new VPAdapter((FragmentActivity) itemView.getContext());
            vpItems.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
            vpItems.setAdapter(adapter);
            vpItems.setOffscreenPageLimit(1);

            View child = vpItems.getChildAt(0);
            if (child instanceof RecyclerView) {
                child.setOverScrollMode(View.OVER_SCROLL_NEVER);
            }
        }
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Interfaces">

        public void update(List<String> updateObject, List<Object> payloads) {
//            this.item = updateObject;
//            if (payloads.isEmpty()) {
//                List<ItemSimpleItem> flexItems = new ArrayList<>();
//                for (String String : updateObject) {
//                    flexItems.add(new ItemSimpleItem(String));
//                }
//
//                adapter.updateDataSet(flexItems, true);
//
//            } else {
//                for (Object payload : payloads) {
//
//                }
//            }
        }
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Methods">
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Getter & Setter">
        // </editor-fold>
    }
}
