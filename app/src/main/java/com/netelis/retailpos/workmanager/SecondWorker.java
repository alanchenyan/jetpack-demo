package com.netelis.retailpos.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SecondWorker extends Worker {

    public SecondWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Data out = new Data.Builder()
                .putString("result", "SecondWorker执行完了")
                .putInt("status", 200)
                .build();

        Log.i("AlanChen","SecondWorker执行完了");

        return Result.success(out);
    }
}
