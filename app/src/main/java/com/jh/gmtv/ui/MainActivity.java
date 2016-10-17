package com.jh.gmtv.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RadioGroup;

import com.jh.gmtv.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private Unbinder bind;
    RadioGroup mRg;
    private Fragment homeFragment;
    private Fragment columnFragemnt;
    private Fragment liveFragment;
    private Fragment myFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去标题
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        init();
        initDao();
    }
    private void initDao() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt_home:
                        select(0);
                        break;
                    case R.id.bt_column:
                        select(1);
                        break;
                    case R.id.bt_live:
                        select(2);
                        break;
                    case R.id.bt_my:
                        select(3);
                        break;
                }
            }
        });
    }
    private void init() {
        //初始化第一个界面
        select(0);
        mRg = (RadioGroup) findViewById(R.id.main_sy);
    }
    private void select(int i) {
        FragmentManager manager = getSupportFragmentManager();//获得Fragment管理器
        FragmentTransaction ft = manager.beginTransaction();
        //开启一个事务
        hideFragment(ft);   //先隐藏 Fragment

        switch (i) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = FragmentFactory.setFragment(i);
                    ft.add(R.id.main_fl, homeFragment);
                } else {
                    ft.show(homeFragment);
                }
                break;
            case 1:
                if (columnFragemnt == null) {
                    columnFragemnt = FragmentFactory.setFragment(i);
                    ft.add(R.id.main_fl, columnFragemnt);
                } else {
                    ft.show(columnFragemnt);
                }
                break;
            case 2:
                if (liveFragment == null) {
                    liveFragment = FragmentFactory.setFragment(i);
                    ft.add(R.id.main_fl, liveFragment);
                } else {
                    ft.show(liveFragment);
                }
                break;
            case 3:
                if (myFragment == null) {
                    myFragment = FragmentFactory.setFragment(i);
                    ft.add(R.id.main_fl, myFragment);
                } else {
                    ft.show(myFragment);
                }
                break;
        }
        ft.commit();   //提交事务
    }

    //隐藏所有Fragment
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }
        if (columnFragemnt != null) {
            fragmentTransaction.hide(columnFragemnt);
        }
        if (liveFragment != null) {
            fragmentTransaction.hide(liveFragment);
        }
        if (myFragment != null) {
            fragmentTransaction.hide(myFragment);
        }
    }

    @Override
    protected void onDestroy() {
        bind.unbind();
        super.onDestroy();
    }
}
