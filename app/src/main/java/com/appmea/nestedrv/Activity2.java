package com.appmea.nestedrv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;
import timber.log.Timber;

public class Activity2 extends AppCompatActivity {
    // ====================================================================================================================================================================================
    // <editor-fold desc="Constants">
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Properties">

    @BindView(R.id.rv_items) Child rvItems;
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Constructor">

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, Activity2.class);
        context.startActivity(starter);
    }
    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Android Lifecycle">

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.plant(new Timber.DebugTree());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ButterKnife.bind(this);
        initRV();
    }


    // </editor-fold>


    // ====================================================================================================================================================================================
    // <editor-fold desc="Initialisation">

    private void initRV() {
        List<IFlexible> flexItems = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(String.valueOf(i));
        }

        for (String String : strings) {
            flexItems.add(new ItemSimpleItem(String));
        }


        FlexibleAdapter<IFlexible> adapter = new FlexibleAdapter(flexItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvItems.setNestedScrollingEnabled(true);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(adapter);
    }
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
