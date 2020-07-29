package com.appmea.nestedrv;

import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;


public class ItemSimpleItem extends AbstractFlexibleItem<ItemSimpleItem.VHSimpleItem> {
    // ====================================================================================================================================================================================
    // <editor-fold desc="Constants">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Properties">

    private String item;
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Constructor">

    public ItemSimpleItem(String item) {
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
        return R.layout.item_simple_item;
    }

    @Override
    public VHSimpleItem createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new VHSimpleItem(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, VHSimpleItem holder, int position, List<Object> payloads) {
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
    static class VHSimpleItem extends FlexibleViewHolder {
        // ====================================================================================================================================================================================
        // <editor-fold desc="Constants">
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Properties">

        private String item;

        @BindView(R.id.tv_text) TextView tvText;
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Constructor">

        public VHSimpleItem(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            ButterKnife.bind(this, view);

            initListener();
        }
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Android Lifecycle">
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Initialisation">

        private void initListener() {
        }
        // </editor-fold>


        // ====================================================================================================================================================================================
        // <editor-fold desc="Interfaces">

        public void update(String updateObject, List<Object> payloads) {
            this.item = updateObject;
            if (payloads.isEmpty()) {
                tvText.setText(item);
            } else {
                for (Object payload : payloads) {

                }
            }
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
