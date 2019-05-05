package com.netelis.retailpos.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ProductDao getProductDao();
}