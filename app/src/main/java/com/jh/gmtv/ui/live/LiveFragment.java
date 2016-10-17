package com.jh.gmtv.ui.live;


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
public class LiveFragment extends Fragment {


    private static LiveFragment liveFragment;

    public LiveFragment() {
        // Required empty public constructor
    }
    //创建Fragment对象
    public  static Fragment setFragment(){
        if (liveFragment==null)
            synchronized (HomeFragment.class){
                if (liveFragment==null){
                    liveFragment = new LiveFragment();
                }
            }
        return liveFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live, container, false);
    }

}
