package com.netelis.retailpos.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.netelis.retailpos.BR;

/**
 *  继承BaseObservable 实现双向绑定
 */
public class Person extends BaseObservable {

    private String name;
    private String age;
    private String sex;

    public Person() {

    }

    public Person(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }
}
