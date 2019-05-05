package com.netelis.retailpos.paging;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;


public class TeacherPresenter {

    private static final int PAGE_SIZE = 20;
    private static final boolean ENABLE_PLACEHOLDERS = false;

    public final LiveData<PagedList<Teacher>> allDatas;

    public TeacherPresenter() {
        allDatas = new LivePagedListBuilder(new TeacherFactory(),
                new PagedList.Config.Builder()
                        .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
                        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
                        .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
                        .build()
        ).build();
    }

}
