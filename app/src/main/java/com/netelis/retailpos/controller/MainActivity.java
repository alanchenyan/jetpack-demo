package com.netelis.retailpos.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.netelis.retailpos.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void lifeCycle(View view) {
        startActivity(new Intent(this, LifecycleActivity.class));
    }

    public void liveData(View view) {
        startActivity(new Intent(this, LiveDataActivity.class));
    }

    public void viewModel(View view) {
        startActivity(new Intent(this, ViewModelActivity.class));
    }

    public void dataBinding(View view) {
        startActivity(new Intent(this, DataBindingActivity.class));
    }
}

