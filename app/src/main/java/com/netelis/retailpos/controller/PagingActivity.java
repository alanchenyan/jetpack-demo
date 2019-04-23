package com.netelis.retailpos.controller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.netelis.retailpos.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        ButterKnife.bind(this);

    }

    @BindView(R.id.tv_name)
    TextView tvName;

}
