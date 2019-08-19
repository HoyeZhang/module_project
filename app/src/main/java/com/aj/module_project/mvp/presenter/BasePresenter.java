package com.aj.module_project.mvp.presenter;

import com.aj.module_project.mvp.model.IModel;
import com.aj.module_project.mvp.ui.IView;

/**
 * @author zhy
 * @time 2019/8/19.
 */
public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    public  V view;
    @Override
    public void setView(IView view) {
        this.view = (V) view;
    }

    @Override
    public void destroy() {

    }
}
