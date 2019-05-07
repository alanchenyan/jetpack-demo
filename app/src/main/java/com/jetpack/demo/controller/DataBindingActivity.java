package com.jetpack.demo.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jetpack.demo.R;
import com.jetpack.demo.databinding.ActivityDataBindingBinding;
import com.jetpack.demo.databinding.Person;

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
