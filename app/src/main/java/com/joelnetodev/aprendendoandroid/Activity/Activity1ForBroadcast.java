package com.joelnetodev.aprendendoandroid.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.joelnetodev.aprendendoandroid.R;

public class Activity1ForBroadcast extends ActivityMain
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nova Activity Broadcast");
    }
}