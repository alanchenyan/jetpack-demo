package com.jetpack.demo.controller;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.jetpack.demo.R;
import com.jetpack.demo.workmanager.FirstWorker;
import com.jetpack.demo.workmanager.MainWorker;
import com.jetpack.demo.workmanager.PeriodicWork;
import com.jetpack.demo.workmanager.SecondWorker;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);
        ButterKnife.bind(this);

        doOneTimeWorkRequest();

        doPeriodicWorkRequest();

        doLinkWorkRequest();
    }




    private void doOneTimeWorkRequest(){
        //类似于intent的bundle
        Data parameter = new Data.Builder()
                .putString("name", "AlanChen")
                .putInt("age", 20)
                .build();

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)//联网状态
                .setRequiresBatteryNotLow(true)//低电量不操作
                .setRequiresCharging(true)//充电时候才开始
                //.setRequiresDeviceIdle(true)//待机状态下才执行，api 23 以上
                .setRequiresStorageNotLow(true)//存储空间不能太小
                .build();


        WorkRequest workRequest = new OneTimeWorkRequest.Builder(MainWorker.class)
                .setConstraints(constraints)//添加约束
                .setInputData(parameter)//传递data到worker中
                .build();


        //加入任务管理,根据Constraints条件执行
        WorkManager.getInstance().enqueue(workRequest);

        //通过workRequest的唯一标记id，获取返回数据
        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.getId())
                .observe(this, workStatus -> {
                    //接收从worker中返回的任务结果,最好在这里判断status为success再做具体操作
                    if (workStatus.getState() == WorkInfo.State.SUCCEEDED) {
                        Data datas = workStatus.getOutputData();
                        String result = datas.getString("result");
                        int status = datas.getInt("status", 0);
                        tvStatus.setText("Work返回状态："+status);
                        tvName.setText("Work结果："+result);
                    }
                });
    }

    private void doPeriodicWorkRequest(){
                 //间隔时间最少为15分钟
                WorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(PeriodicWork.class, 15, TimeUnit.MINUTES)
                .setBackoffCriteria(BackoffPolicy.LINEAR, 20, TimeUnit.MINUTES)
                .build();

        WorkManager.getInstance().enqueue(periodicWorkRequest);

        WorkManager.getInstance().getWorkInfoByIdLiveData(periodicWorkRequest.getId())
                .observe(this, workStatus -> {

                    Toast.makeText(this,"PeriodicWork执行",Toast.LENGTH_SHORT).show();
                });
    }

    private void doLinkWorkRequest(){

        OneTimeWorkRequest requestA = new OneTimeWorkRequest.Builder(FirstWorker.class).build();
        OneTimeWorkRequest requestB = new OneTimeWorkRequest.Builder(SecondWorker.class).build();

        WorkManager.getInstance().beginWith(requestA).then(requestB).enqueue();


        WorkManager.getInstance().getWorkInfoByIdLiveData(requestA.getId())
                .observe(this, workStatus -> {

                    if (workStatus.getState() == WorkInfo.State.SUCCEEDED) {
                        Data datas = workStatus.getOutputData();
                        String result = datas.getString("result");
                        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
                    }
                });

        WorkManager.getInstance().getWorkInfoByIdLiveData(requestB.getId())
                .observe(this, workStatus -> {

                    if (workStatus.getState() == WorkInfo.State.SUCCEEDED) {
                        Data datas = workStatus.getOutputData();
                        String result = datas.getString("result");
                        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
                    }
                });


    }

    @BindView(R.id.tv_status)
    TextView tvStatus;

    @BindView(R.id.tv_name)
    TextView tvName;
}
