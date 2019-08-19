package com.aj.module_project.mvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.aj.module_project.R;
import com.aj.module_project.mvp.contract.ImageListContract;
import com.aj.module_project.mvp.presenter.ImageLoadPresenter;

/**
 * @author zhy
 * @time 2019/8/18.
 */
public class ImageListActivity extends BaseActivity<ImageLoadPresenter> implements ImageListContract.View {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        mPresenter = new ImageLoadPresenter();
        mPresenter.setView(this);
        mPresenter.loadData();

    }

    @Override
    public void loadDataSuccess() {
        Toast.makeText(this,"获取成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadDataError() {
        Toast.makeText(this,"获取失败",Toast.LENGTH_SHORT).show();
    }
}
