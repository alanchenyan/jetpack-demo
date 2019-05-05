package com.netelis.retailpos.room;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private Executor mIOExecutor;

    public AppExecutors() {
        mIOExecutor = Executors.newSingleThreadExecutor();
    }

    public Executor getDiskIO() {
        return mIOExecutor;
    }

}