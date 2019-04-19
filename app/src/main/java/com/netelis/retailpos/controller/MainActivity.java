package com.netelis.retailpos.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.netelis.retailpos.R;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.lifeCycleBtn)
    public void lifeCycle() {
        startActivity(new Intent(this, LifecycleActivity.class));
    }

    @OnClick(R.id.liveDataBtn)
    public void liveData() {
        startActivity(new Intent(this, LiveDataActivity.class));
    }

    @OnClick(R.id.viewModelBtn)
    public void viewModel() {
        startActivity(new Intent(this, ViewModelActivity.class));
    }

    @OnClick(R.id.dataBindingBtn)
    public void dataBinding() {
        startActivity(new Intent(this, DataBindingActivity.class));
    }

    @OnClick(R.id.daggerBtn)
    public void dagger() {
        startActivity(new Intent(this, DaggerActivity.class));
    }

}

