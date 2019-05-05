package com.netelis.retailpos.paging;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import java.util.ArrayList;
import java.util.List;

public class TeacherDataSource extends PositionalDataSource<Teacher> {

    List<Teacher> datas = new RestData().getTeachers();

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Teacher> callback) {
        callback.onResult(fetchItems(params.requestedStartPosition, params.pageSize), params.requestedStartPosition, datas.size());
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Teacher> callback) {
        callback.onResult(fetchItems(params.startPosition, params.loadSize));
    }


    private List<Teacher> fetchItems(int startPosition, int pageSize){
        List<Teacher> teachers = new ArrayList<>();

        if(startPosition+pageSize<= datas.size()){
            teachers.addAll(datas.subList(startPosition,startPosition+pageSize));
        }
        return teachers;
    }
}
