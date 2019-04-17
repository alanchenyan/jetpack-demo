package com.netelis.retailpos.controller;

import android.os.Bundle;

import com.netelis.retailpos.R;
import com.netelis.retailpos.lifecycle.MyObserver;

import androidx.appcompat.app.AppCompatActivity;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        getLifecycle().addObserver(new MyObserver());
    }
}
