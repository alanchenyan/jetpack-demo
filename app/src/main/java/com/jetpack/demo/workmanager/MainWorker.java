package com.jetpack.demo.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MainWorker extends Worker {

    public MainWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        //在workRequest中传递来的data，
        Data data = getInputData();
        String name = data.getString("name");
        int age = data.getInt("age", 0);

        //返回任务的结果数据，使用setOutputData
        Data out = new Data.Builder()
                .putString("result", "Hello "+name +",you age is "+age)
                .putInt("status", 200)
                .build();

        return Result.success(out);
    }
}
