package com.jetpack.demo.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.demo.R;

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

    @OnClick(R.id.navigationBtn)
    public void navigation(){
        startActivity(new Intent(this, NavigationActivity.class));
    }

    @OnClick(R.id.workManagerBtn)
    public void workManager(){
        startActivity(new Intent(this, WorkManagerActivity.class));
    }

    @OnClick(R.id.pagingBtn)
    public void paging(){
        startActivity(new Intent(this, PagingActivity.class));
    }

    @OnClick(R.id.roomBtn)
    public void room(){
        startActivity(new Intent(this, RoomActivity.class));
    }

}

