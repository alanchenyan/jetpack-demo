package com.jetpack.demo.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jetpack.demo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment {

    public ThreeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //返回上一个页面
        view.findViewById(R.id.btn_go_back).setOnClickListener(v -> Navigation.findNavController(v).navigateUp());
    }

}
