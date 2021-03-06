package com.jetpack.demo.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jetpack.demo.R;
import com.jetpack.demo.paging.TeacherPageListAdapter;
import com.jetpack.demo.paging.TeacherPresenter;

import butterknife.ButterKnife;

public class PagingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeacherPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        ButterKnife.bind(this);

        recyclerView = findViewById(R.id.rv_paging);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TeacherPageListAdapter adapter = new TeacherPageListAdapter();
        recyclerView.setAdapter(adapter);

        presenter = new TeacherPresenter();

        presenter.allDatas.observe(this, teachers -> adapter.submitList(teachers));

    }


}
