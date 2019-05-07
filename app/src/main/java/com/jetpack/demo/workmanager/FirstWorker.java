package com.jetpack.demo.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FirstWorker extends Worker {

    public FirstWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Data out = new Data.Builder()
                .putString("result", "FirstWorker执行完了")
                .putInt("status", 200)
                .build();

        Log.i("AlanChen","FirstWorker执行完了");

        return Result.success(out);
    }
}
