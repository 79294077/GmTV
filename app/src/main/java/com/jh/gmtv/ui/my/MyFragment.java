package com.jh.gmtv.ui.my;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.gmtv.R;
import com.jh.gmtv.ui.home.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    private static MyFragment myFragment;

    public MyFragment() {
        // Required empty public constructor
    }
    //创建Fragment对象
    public  static Fragment setFragment(){
        if (myFragment==null)
            synchronized (HomeFragment.class){
                if (myFragment==null){
                    myFragment = new MyFragment();
                }
            }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

}
