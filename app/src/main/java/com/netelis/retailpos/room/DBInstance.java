package com.netelis.retailpos.room;

import android.content.Context;

import androidx.room.Room;

public class DBInstance {

    private static final String DB_NAME = "room_test";
    public static AppDataBase appDataBase;

    public static AppDataBase getInstance(Context context){
        if(appDataBase==null){
            synchronized (DBInstance.class){
                if(appDataBase==null){
                    //.allowMainThreadQueries() 正式使用时，请务必去掉这行代码，因为它会让所有耗时操作运行在主线程！应该使用AsyncTask，RxJava 2，和BasicSample示例中使用的Executor
                    return Room.databaseBuilder(context,AppDataBase.class, DB_NAME)
                            .build();
                }
            }
        }
        return appDataBase;
    }
}