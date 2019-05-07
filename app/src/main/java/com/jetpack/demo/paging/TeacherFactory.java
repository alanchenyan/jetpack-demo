package com.jetpack.demo.paging;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class TeacherFactory extends DataSource.Factory<Integer, Teacher> {

    private MutableLiveData<TeacherDataSource> mSourceLiveData =
            new MutableLiveData<>();


    @Override
    public DataSource<Integer, Teacher> create() {
        TeacherDataSource teacherDataSource = new TeacherDataSource();
        mSourceLiveData.postValue(teacherDataSource);
        return teacherDataSource;
    }
}
