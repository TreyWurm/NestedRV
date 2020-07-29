package com.appmea.nestedrv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;

public class SimpleFragment extends Fragment {
    // ====================================================================================================================================================================================
    // <editor-fold desc="Constants">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Properties">
    // </editor-fold>
    public static SimpleFragment newInstance(String string) {

        Bundle args = new Bundle();
        args.putString("key", string);
        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    // ====================================================================================================================================================================================
    // <editor-fold desc="Constructor">

    private static final     String       TAG = "tag_simple";
    private                  View         view;
    @BindView(R.id.rv_items) RecyclerView rvItems;
    @BindView(R.id.tv_text)  TextView     tvText;


    @CallSuper
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (view != null && view.getParent() == null) {
            return view;
        }

        view = inflater.inflate(R.layout.fragment_simple, container, false);
        ButterKnife.bind(this, view);

        tvText.setText(getArguments().getString("key"));
        initRV();

        return view;
    }
    // </editor-fold>


    private void initRV() {
        List<ItemSimpleItem> flexItems = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(String.valueOf(i));
        }

        for (String String : strings) {
            flexItems.add(new ItemSimpleItem(String));
        }

        FlexibleAdapter<ItemSimpleItem> adapter = new FlexibleAdapter<>(flexItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        rvItems.setNestedScrollingEnabled(true);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(adapter);
    }
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
