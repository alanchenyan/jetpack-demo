package com.jetpack.demo.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.demo.R;
import com.jetpack.demo.lifecycle.MyObserver;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        getLifecycle().addObserver(new MyObserver());
    }
}
