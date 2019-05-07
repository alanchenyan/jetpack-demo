package com.jetpack.demo.controller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.demo.R;
import com.jetpack.demo.dagger.DaggerActivityComponent;
import com.jetpack.demo.dagger.Student;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaggerActivity extends AppCompatActivity {
    @Inject
    Student student;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ButterKnife.bind(this);

        DaggerActivityComponent.builder().build().inject(this);

        student.setName("AlanChen");

        tvName.setText(student.getName());
    }

    @BindView(R.id.tv_name)
    TextView tvName;

}
