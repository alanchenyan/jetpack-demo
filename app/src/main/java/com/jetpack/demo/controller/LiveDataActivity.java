package com.jetpack.demo.controller;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.jetpack.demo.R;
import com.jetpack.demo.livedata.LiveUser;

public class LiveDataActivity extends AppCompatActivity {

    private LiveUser user ;

    //用于演示 transformation
    private MutableLiveData<LiveUser> liveUserLiveData = new MutableLiveData<>();

    private LiveData<String> userInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        ButterKnife.bind(this);

        initData();
        observeData();
    }

    private void initData(){

        user = new LiveUser( "AC",20, "男");

        //liveData转换的操作
        liveUserLiveData.setValue(user);

        //map转化liveData的返回类型，用一个liveData可以向下转化出所需要的liveData。还有一个switchmap函数类似
        userInfo = Transformations.map(liveUserLiveData, user -> "姓名：" + user.getName().getValue() + "   年龄：" + user.getAge().getValue() + "   性别：" + user.getSex());
    }

    private void observeData(){

        //普通的 user属性
        tvSex.setText(user.getSex());

        //liveData的user属性
        user.getAge().observe(this, integer -> tvAge.setText(integer + ""));

        //liveData的变化setValue，应在model中，View只负责显示
        observeLiveDataToView(user.getName(), tvName);

        observeLiveDataToView(userInfo, tvInfo);
    }

    @OnClick(R.id.changeUserBtn)
    public void changeUser() {
        //UI上这两个会变化，因为使用了liveData
        user.setAge(18);
        user.setName("AlanChen");

        //UI上这个不会变化，因为是普通的属性字段
        user.setSex("女");

        //transformations map 的演示变化
        liveUserLiveData.setValue(user);

        Toast.makeText(this, "请注意，性别字段在View上并未变化", Toast.LENGTH_SHORT).show();
        //普通属性的字段，想要同步变化，还需要再setText一次，而且是要每变化一次，都要手动调用代码setText。liveData则会响应变化tvSex.setText(user.getSex());
    }


    /**
     * @param liveData liveData
     * @param view     view
     */
    private void observeLiveDataToView(LiveData<String> liveData, TextView view) {
        //JDK8 中的 方法引用 view::setText
        liveData.observe(this, view::setText);
    }



    @BindView(R.id.tv_age_live)
    TextView tvAge;
    @BindView(R.id.tv_name_live)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_info_live)
    TextView tvInfo;


}
