package com.jh.gmtv.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.gmtv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static HomeFragment homeFragment;

    public HomeFragment() {
        // Required empty public constructor
    }
    //创建Fragment对象
    public  static Fragment setFragment(){
        if (homeFragment==null)
            synchronized (HomeFragment.class){
                if (homeFragment==null){
                    homeFragment=new HomeFragment();
                }
            }
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
