package com.netelis.retailpos.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netelis.retailpos.R;


public class SecondFragment extends Fragment {

    public SecondFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //返回上一个页面
        view.findViewById(R.id.btn_go_back).setOnClickListener(v -> Navigation.findNavController(v).navigateUp());
        //跳到ThreeFragment
        view.findViewById(R.id.btn_go_three).setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_secondFragment_to_threeFragment));
    }
}
