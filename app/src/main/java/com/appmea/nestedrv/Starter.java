package com.appmea.nestedrv;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Starter extends AppCompatActivity {
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_1)
    void start1() {
        MainActivity.startActivity(this);
    }

    @OnClick(R.id.tv_2)
    void start2() {
        Activity2.startActivity(this);
    }
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
