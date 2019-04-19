package com.netelis.retailpos.dagger;

import com.netelis.retailpos.controller.DaggerActivity;

import dagger.Component;

@Component
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}
