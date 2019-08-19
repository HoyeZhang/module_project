package com.aj.module_project.mvp.presenter;

import com.aj.module_project.mvp.ui.IView;

/**
 * @author zhy
 * @time 2019/5/22.
 */
public interface IPresenter {
    /*
    设置view
     */
    void setView(IView view);
    /*
    同步view生命周期，切断联系
     */
    void destroy();
}

