package com.netelis.retailpos.room;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class AppExecutors {

    ScheduledExecutorService executorService ;

    public AppExecutors() {
        executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().daemon(true).build());
    }

    public Executor getDiskIO() {
        return executorService;
    }

}
