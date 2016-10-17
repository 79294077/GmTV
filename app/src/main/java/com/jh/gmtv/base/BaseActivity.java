package com.jh.gmtv.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.jh.gmtv.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        //去标题
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getContentView());
        //绑定黄油刀
        bind = ButterKnife.bind(this);
        init();
    }
    protected abstract void init();

    public abstract int getContentView();

    @Override
    protected void onDestroy() {
        //解绑
        bind.unbind();
        super.onDestroy();
    }
}
