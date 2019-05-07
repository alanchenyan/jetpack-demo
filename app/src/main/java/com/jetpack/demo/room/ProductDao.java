package com.jetpack.demo.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("Select * from product")
    List<Product> getAll();

    @Query("Select * from product Where uid In (:ids)")
    List<Product> loadAllByIds(int[] ids);

    @Insert
    void insertAll(Product... products);


    @Update
    void update(Product... products);

    @Query("update product set prodName =:name1 where uid=:uid")
    void updateCustom(String name1, int uid);


    @Delete
    void delete(Product... products);


    @Query("Delete from product")
    void deleteAll();

}
