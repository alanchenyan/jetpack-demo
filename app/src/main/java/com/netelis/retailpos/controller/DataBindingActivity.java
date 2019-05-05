package com.netelis.retailpos.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.netelis.retailpos.R;
import com.netelis.retailpos.databinding.ActivityDataBindingBinding;
import com.netelis.retailpos.databinding.Person;

public class DataBindingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

        ActivityDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        Person person = new Person("AlanChen", "20", "男");
        binding.setPerson(person);

    }

}
