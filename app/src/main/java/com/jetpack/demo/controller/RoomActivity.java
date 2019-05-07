package com.jetpack.demo.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.demo.R;
import com.jetpack.demo.room.AppExecutors;
import com.jetpack.demo.room.DBInstance;
import com.jetpack.demo.room.Product;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    AppExecutors executors = new AppExecutors();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

    }

    @Override
    protected void onResume() {
        super.onResume();

        executors.getDiskIO().execute(() -> testData());
    }

    private void testData(){

        //插入数据
        Product product = new Product();
        product.setProdName("牛肉面");

        Product product2 = new Product();
        product2.setProdName("鸡排");

        Product product3 = new Product();
        product3.setProdName("藕片");

        DBInstance.getInstance(getApplicationContext()).getProductDao().insertAll(product,product2,product3);


        //获取数据
        List<Product> list = DBInstance.getInstance(getApplicationContext()).getProductDao().getAll();

        //获取数据2
        int []ids = {1,2};
        List<Product> list2 = DBInstance.getInstance(getApplicationContext()).getProductDao().loadAllByIds(ids);


        //更新数据
        Product productUpdated = list.get(0);
        productUpdated.setProdName("猪扒包");
        DBInstance.getInstance(getApplicationContext()).getProductDao().update(productUpdated);

        //更新数据2
        DBInstance.getInstance(getApplicationContext()).getProductDao().updateCustom("iPhone",1);

        //删除数据
        DBInstance.getInstance(getApplicationContext()).getProductDao().delete(product);

        DBInstance.getInstance(getApplicationContext()).getProductDao().deleteAll();

        List<Product> data = DBInstance.getInstance(getApplicationContext()).getProductDao().getAll();

        System.out.println(data.size());
    }


}
