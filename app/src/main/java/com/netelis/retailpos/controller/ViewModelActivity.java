package com.netelis.retailpos.controller;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProviders;

import com.netelis.retailpos.R;
import com.netelis.retailpos.entity.User;
import com.netelis.retailpos.livedata.LiveUser;
import com.netelis.retailpos.viewmodel.UserViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewModelActivity extends AppCompatActivity {

    UserViewModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        ButterKnife.bind(this);

        model = ViewModelProviders.of(this).get(UserViewModel.class);
        model.getUser().observe(this, user -> {
            // update UI

            Log.i("AlanChen","ViewModel update UI.......");

            tvName.setText(user.getName());
            tvAge.setText(user.getAge()+"");
            tvSex.setText(user.getSex());

        });
    }

    public void changeUser(View view) {
        model.loadUser();
    }


    @BindView(R.id.tv_age_live)
    TextView tvAge;
    @BindView(R.id.tv_name_live)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;

}
