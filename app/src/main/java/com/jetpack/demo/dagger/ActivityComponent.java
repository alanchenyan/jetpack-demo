package com.jetpack.demo.dagger;

import com.jetpack.demo.controller.DaggerActivity;

import dagger.Component;

@Component
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}
