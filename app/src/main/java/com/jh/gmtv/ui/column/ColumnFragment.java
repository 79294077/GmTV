package com.jh.gmtv.ui.column;


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
public class ColumnFragment extends Fragment {


    private static ColumnFragment columnFragment;

    public ColumnFragment() {
        // Required empty public constructor
    }

    //创建Fragment对象
    public  static Fragment setFragment(){
        if (columnFragment==null)
            synchronized (HomeFragment.class){
                if (columnFragment==null){
                    columnFragment = new ColumnFragment();
                }
            }
        return columnFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_column, container, false);
    }

}
