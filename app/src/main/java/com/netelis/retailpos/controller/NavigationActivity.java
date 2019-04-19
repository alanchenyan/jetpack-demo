package com.netelis.retailpos.controller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.netelis.retailpos.R;
import com.netelis.retailpos.dagger.DaggerActivityComponent;
import com.netelis.retailpos.entity.Student;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

    }

    @BindView(R.id.tv_name)
    TextView tvName;

}
