package com.netelis.retailpos.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> user;

    public LiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<User>();
            loadUser();
        }
        return user;
    }

    public void loadUser() {
        // Do an asynchronous operation to fetch user.
        Random random = new Random(); // 1 ～10 的随机数
        User u = new User("AC",random.nextInt(10)+1+"","男");
        user.setValue(u);
    }


}
