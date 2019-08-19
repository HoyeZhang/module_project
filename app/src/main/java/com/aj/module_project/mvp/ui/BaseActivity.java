package com.aj.module_project.mvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aj.module_project.mvp.presenter.IPresenter;

/**
 * @author zhy
 * @time 2019/8/18.
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity{
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
