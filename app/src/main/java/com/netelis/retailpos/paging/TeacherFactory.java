package com.netelis.retailpos.paging;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.netelis.retailpos.entity.Teacher;

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
