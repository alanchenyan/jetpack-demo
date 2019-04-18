package com.netelis.retailpos.livedata;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;


public class LiveUser {

    private MutableLiveData<String> name = new MediatorLiveData<>();//LiveData属性

    private MutableLiveData<Integer> age = new MutableLiveData<>(); //LiveData属性

    private String sex; // 普通属性

    public LiveUser(String name, Integer age,String sex) {
        this.name.setValue(name);
        this.age.setValue(age);
        this.sex = sex;
    }


    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public MutableLiveData<Integer> getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age.setValue(age);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
