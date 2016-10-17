package com.jh.gmtv.ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.jh.gmtv.ui.column.ColumnFragment;
import com.jh.gmtv.ui.home.HomeFragment;
import com.jh.gmtv.ui.live.LiveFragment;
import com.jh.gmtv.ui.my.MyFragment;

public class FragmentFactory {
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_HOT = 1;
    private static final int FRAGMENT_SORT = 2;
    private static final int FRAGMENT_SHOP = 3;
    private static SparseArray<Fragment> list = new SparseArray<>();

    public static Fragment setFragment(int key) {
        Fragment fragment = list.get(key);
        if (fragment == null) {
            switch (key) {
                case FRAGMENT_HOME:
                    fragment = HomeFragment.setFragment();
                    break;
                case FRAGMENT_HOT:
                    fragment = ColumnFragment.setFragment();
                    break;
                case FRAGMENT_SORT:
                    fragment = LiveFragment.setFragment();
                    break;
                case FRAGMENT_SHOP:
                    fragment = MyFragment.setFragment();
                    break;
            }
            list.put(key,fragment);
        }
        return fragment;
    }
}
