package com.aj.module_project.mvp.presenter;

import com.aj.module_project.mvp.model.IModel;
import com.aj.module_project.mvp.ui.IView;

/**
 * @author zhy
 * @time 2019/8/19.
 */
public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    public  V view;
    public M model;


    public BasePresenter(M model,V view){
        this.model = model;
        this.view = view;

    }

    @Override
    public void destroy() {

    }
}
