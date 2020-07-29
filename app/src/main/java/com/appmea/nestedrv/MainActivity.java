package com.appmea.nestedrv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_items) RecyclerView rvItems;

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.plant(new Timber.DebugTree());
//        FlexibleAdapter.enableLogs(Log.Level.VERBOSE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRV();
    }

    private void initRV() {
        List<IFlexible> flexItems = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            strings.add(String.valueOf(i));
        }

        for (String String : strings) {
            flexItems.add(new ItemSimpleItem(String));
        }

        flexItems.add(new ItemCouponVP(strings));
        FlexibleAdapter<IFlexible> adapter = new FlexibleAdapter(flexItems) {
            @Override
            public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
                Timber.e("onViewRecycled: %s", holder.getAdapterPosition());
                super.onViewRecycled(holder);
            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvItems.setNestedScrollingEnabled(true);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(adapter);
    }
}